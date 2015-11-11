package web.formatter;

import domain.Course;
import domain.Role;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by john on 15-10-18.
 */
public class Rolesformatter implements Formatter<Set<Role>> {
    @Override
    public Set<Role> parse(String text, Locale locale) throws ParseException {

        if (text == null) {
            return null;
        }
        String[] roles = text.split(";");
        Set<Role> roleList = new HashSet<>();
        for (String name : roles) {
            Role role = new Role();
            role.setName(name);
            roleList.add(role);
        }
        return roleList;
    }


    @Override
    public String print(Set<Role> object, Locale locale) {

        List<String> names = object.stream().map(role -> role.getName())
                .collect(Collectors.toList());
        return String.join(";", names);
    }
}
