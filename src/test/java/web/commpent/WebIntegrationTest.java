package web.commpent;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import config.DaoConfig;
import config.ServiceConfiguration;
import config.WebConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by john on 15-11-11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ContextConfiguration(classes = {DaoConfig.class, ServiceConfiguration.class, WebConfiguration.class,})
@WebAppConfiguration
@ActiveProfiles("dev")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})

public @interface WebIntegrationTest {
}
