package net.therap.facebook.interceptors;

import net.therap.facebook.entities.UserInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: rafsan.jani
 * @since: 12/7/15.
 */
public class ConditionalInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo != null) {
            response.sendRedirect("/FacebookSpring/profile");
            return false;
        }
        return true;
    }
}
