package web.formatter;

import domain.*;
import domain.Number;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by john on 15-10-18.
 */
@Component
public class NumberFormatter implements Formatter<domain.Number> {


    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        if (text == null) {
            return null;
        }
        Number number = new Number();
        String[] strings = text.split("-");
        if (strings.length > 1) {
            number.setPrefix(strings[0]);

            number.setSuffix(strings[1]);

        }
        return number;
    }

    @Override
    public String print(Number object, Locale locale) {


        return String.join("-", object.getPrefix(), object.getSuffix());
    }
}
