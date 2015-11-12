package web;

import domain.Role;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by john on 15-11-6.
 */
@RestController
public class UserController {
    @Autowired
    private StudentService studentService;

    //    @RequestMapping(value = "/")
//    public ModelAndView show() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/user/login");
//        return modelAndView;
//    }
    @ModelAttribute("stureg")
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public Student showRegisterForm() {

        return new Student();
    }

    @ModelAttribute("stulogin")
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public Student login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/login");
//        return modelAndView;
        return new Student();
    }

    /**
     * @param stulogin
     * @param httpSession
     * @param model
     * @param request
     * @param
     * @return RequestParam  和  ModelAttribute  请求到的数据时好时坏
     */
    @RequestMapping(value = "/user/loginit", method = RequestMethod.POST)
    public ModelAndView loginSyetem(@ModelAttribute("stulogin") Student stulogin,
                                    HttpSession httpSession,
                                    Model model,
//                                    @RequestParam(value = "loginname",required = true)String user
                                    HttpServletRequest request) {
        System.out.println("*********************" + stulogin.toString());
//                + "******************************************");
//        System.out.println("**************" + request.getParameterValues("loginname") + ":::");  //  test  function
//        String user []= request.getParameterValues("loginname");
//        stulogin.setName(user[0]);
        ModelAndView modelAndView = new ModelAndView();
        if (stulogin.getName().isEmpty() || stulogin.getPassword().isEmpty()) {
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }
        Student stu = studentService.findUser(stulogin);
        if (stu == null) {
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }
        httpSession.setAttribute("student", stu);
        model.addAttribute("student", stu);
        if (stu.isAdmin()) {
            modelAndView.setViewName("redirect:/students");
            return modelAndView;
        }
        if (!stu.isAdmin()) {
            model.addAttribute("student", stu);
            modelAndView.setViewName("/student/update");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }

    /**
     * @param stureg
     * @param s
     * @return
     */
    @RequestMapping(value = "/user/registerit", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("stureg") Student stureg, @RequestParam("userproperty") String s) {

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(s + "*************************hughfuduighdfig");
        System.out.println(stureg.toString());
        Role role = new Role();
        role.setName(s);
        stureg.setRole(role);
        studentService.addOneStudent(stureg);
        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }
}
