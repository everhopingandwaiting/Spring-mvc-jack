package web;

import domain.Student;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import web.commpent.WebIntegrationTest;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by john on 15-11-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
public class StudentControllerTest extends TestCase {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testStudents() throws Exception {

    }

    public void testShowAddOneForm() throws Exception {

    }

    @Test
    public void testAddStudent() throws Exception {
        RequestPostProcessor requestPostProcessor = new RequestPostProcessor() {
            @Override
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                Student student = new Student();
                student.setName("j.yao");
                student.setPassword("111111");

                request.getSession().setAttribute("student", student);
                return null;
            }
        };


//    Student student = (Student) mockHttpServletRequest.getSession().getAttribute("student");
//    request -> request.getSession().getAttribute("student"
        mockMvc.perform(get("/student/new").with(requestPostProcessor))
                .andExpect(handler().handlerType(StudentController.class))
                .andExpect(handler().methodName("addStudent"))
                .andExpect(view().name("student/addone"))
                .andExpect(model().attribute("student", equalTo(new Student())))
                .andExpect(status().isOk());
    }

    public void testShowUpdate() throws Exception {

    }

    public void testUpdateStudent() throws Exception {

    }

    public void testDeleteStudent() throws Exception {

    }
}