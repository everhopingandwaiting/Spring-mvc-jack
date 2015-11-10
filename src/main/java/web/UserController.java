package web;

import domain.Role;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

/**
 * Created by john on 15-11-6.
 */
@RestController
public class UserController {
    @Autowired
    private StudentService studentService;

    @ModelAttribute("student")
    @RequestMapping(value = "/user/registerone", method = RequestMethod.POST)
    public Student showRegisterForm(@ModelAttribute("student") Student student) {

        return new Student();
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("student") Student student) {

        ModelAndView modelAndView = new ModelAndView();
        studentService.addOneStudent(student);
        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }
}
