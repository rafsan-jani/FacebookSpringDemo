package net.therap.facebook.controller;


import net.therap.facebook.entities.UserInfo;
import net.therap.facebook.model.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author: rafsan.jani
 * @since: 11/26/15.
 */

@Controller
@RequestMapping({"/", "/login"})
public class LoginController {

    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "userInfo", new UserInfo());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult bindingResult,
                          HttpServletResponse response, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        UserInfo user = userServiceImp.makeLogin(userInfo);

        if (user != null) {
            Cookie cookie = new Cookie("userName", user.getUserName() + "*");
            cookie.setMaxAge(1000);
            response.addCookie(cookie);

            httpSession.setAttribute("userInfo", user);

            return "redirect:/profile";
        } else {
            model.addAttribute("error", "Username and password not matched");
            model.addAttribute("command", new UserInfo());
            return "login";
        }
    }

    @RequestMapping("/allUser")
    public String showAll(ModelMap model) {
        if (userServiceImp == null) {
            model.addAttribute("error", "It is empty");
            return "error";
        } else {
            model.addAttribute("allu", userServiceImp.get());
        }
        return "all";
    }

}
