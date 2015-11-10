package web.formatter;

import domain.*;
import domain.Class;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by john on 15-10-14.
 */
public class Classformatter implements Formatter<domain.Class> {
    @Override
    public Class parse(String text, Locale locale) throws ParseException {
        Class aClass = new Class();
        aClass.setName(text);

        return aClass;
    }

    @Override
    public String print(Class object, Locale locale) {
        if (object == null) {
            return null;
        }
        return new StringBuffer().append(object.getName()).toString();
    }
}
