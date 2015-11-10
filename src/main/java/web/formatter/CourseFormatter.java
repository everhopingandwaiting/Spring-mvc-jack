package web.formatter;

import domain.Course;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by john on 15-10-18.
 */
public class CourseFormatter implements Formatter<List<Course>> {
    @Override
    public List<Course> parse(String text, Locale locale) throws ParseException {

        if (text == null) {
            return null;
        }
        String[] courses = text.split(";");
        List<Course> courses1 = new ArrayList<>();
        for (String name : courses) {
            Course course = new Course();
            course.setName(name);
            courses1.add(course);
        }
        return courses1;
    }


    @Override
    public String print(List<Course> object, Locale locale) {

        List<String> names = object.stream().map(course -> course.getName())
                .collect(Collectors.toList());
        return String.join(";", names);
    }
}
