package web;

import domain.Student;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by john on 15-10-16.
 */
public class AuthenicationInteceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Student student = (Student) request.getSession().getAttribute("student");
        String url = request.getRequestURI();
        boolean isRoot = url.endsWith(request.getContextPath() + "/");
        boolean isLogin = url.endsWith(request.getContextPath() + "/login");
        if (isRoot || isLogin) {
            return true;
        } else if (student == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        } else {

            if (url.endsWith(request.getContextPath() + "students") && !(student.isAdmin())) {
                response.sendError(403, "la,  you should not  access  the  page!");
            }
        }
        return true;

    }
}
