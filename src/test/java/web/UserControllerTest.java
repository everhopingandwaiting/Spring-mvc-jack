package web;

import domain.Student;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import web.commpent.WebIntegrationTest;

import static org.junit.Assert.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by john on 15-11-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
        mockMvc = null;
    }

    @Test
    public void testShowRegisterForm() throws Exception {
        Student student = new Student();
        mockMvc.perform(get("/user/register"))
                .andExpect(model().attribute("student", equalTo(student)))
                .andExpect(handler().handlerType(UserController.class))
                .andExpect(handler().methodName("showRegisterForm"))
                .andExpect(view().name("user/register"))

                .andExpect(status().isOk());
    }

    @Test
    public void testLogin() throws Exception {

    }

    @Test
    public void testLoginSyetem() throws Exception {

    }

    @Test
    public void testRegister() throws Exception {

    }
}