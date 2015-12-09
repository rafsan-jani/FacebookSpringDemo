package net.therap.facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author: rafsan.jani
 * @since: 12/6/15.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @RequestMapping(method = RequestMethod.POST)
    public String doLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}
