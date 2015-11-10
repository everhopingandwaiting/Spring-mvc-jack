package web;import domain.Student;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;import org.springframework.web.servlet.ModelAndView;import service.StudentService;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpSession;import java.util.ArrayList;import java.util.List;/** * Created by john on 15-10-14. */@RestControllerpublic class StudentController {    @Autowired    private StudentService studentService;    /**     * @return     */    @ModelAttribute("studentlist")    @RequestMapping(value = "/students", method = RequestMethod.GET)    public List<Student> students() {        return studentService.listAll();    }    /**     * @return     */    @ModelAttribute("student")    @RequestMapping(value = "/student/addone")    public Student showAddOneForm() {        return new Student();    }    @RequestMapping(value = "/student/new", method = RequestMethod.POST)    public ModelAndView addStudent(@ModelAttribute("student") Student student) {        ModelAndView modelAndView = new ModelAndView();        studentService.addOneStudent(student);        modelAndView.setViewName("redirect:/students");        return modelAndView;    }    /**     * @param id     * @param model     * @return     */    @RequestMapping(value = "/student/update/{id}", method = RequestMethod.GET)    public ModelAndView showUpdate(@PathVariable("id") int id, Model model) {        Student student = studentService.find(id, Student.class);        ModelAndView modelAndView = new ModelAndView();        model.addAttribute("student", student);        modelAndView.setViewName("/student/update");        return modelAndView;    }    /**     * @param student     * @param httpSession     * @param model     * @return     */    @RequestMapping("/student/update")    public ModelAndView updateStudent(@ModelAttribute("student") Student student, HttpSession httpSession,                                      Model model) {        ModelAndView modelAndView = new ModelAndView();        studentService.updateStudent(student);        modelAndView.setViewName("redirect:/students");        return modelAndView;    }    /****     * @param ids     * @param request     * @return     */    @RequestMapping(value = "/student", params = "deletebtn")    public ModelAndView deleteStudent(@RequestParam(name = "id", defaultValue = "0") Integer[] ids, HttpServletRequest request) {        ModelAndView modelAndView = new ModelAndView();        modelAndView.setViewName("redirect:/students");        if (ids[0] == 0) {            return modelAndView;        }        System.out.println(request.getParameterValues("id") + "*******&^%$#$%^&%$%^^^^^^^^^^^^^^^^%");        System.out.println(request.getParameterNames().nextElement() + "*************");        ;        String idsel[] = request.getParameterValues("id");        Integer integerID[] = new Integer[idsel.length];        for (int i = 0; i < idsel.length; i++) {            integerID[i] = Integer.parseInt(idsel[i]);            System.out.println(ids[i]);            System.out.println(integerID[i]);        }        studentService.delSelectedStudents(ids);        return modelAndView;    }}