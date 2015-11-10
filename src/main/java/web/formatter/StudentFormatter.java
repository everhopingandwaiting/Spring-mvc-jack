package web.formatter;

import domain.Student;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by john on 15-10-18.
 */
public class StudentFormatter implements Formatter<Student> {
    @Override
    public Student parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Student object, Locale locale) {
        if (object == null) {
            return null;
        }
        return new StringBuffer().append(object.getName()).append("").toString();
    }
}
