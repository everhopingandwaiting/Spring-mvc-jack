package config;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.StudentService;

/**
 * Created by john on 15-10-14.
 */
@Configuration
public class ServiceConfiguration {
    @Bean
    @Autowired
    public StudentService studentService(StudentDao studentDao) {
        return new StudentService(studentDao);
    }
}
