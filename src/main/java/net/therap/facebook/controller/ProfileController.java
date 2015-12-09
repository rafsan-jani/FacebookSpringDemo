package net.therap.facebook.controller;

import net.therap.facebook.entities.UserInfo;
import net.therap.facebook.model.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author: rafsan.jani
 * @since: 11/26/15.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public String showProfileInfo(HttpSession httpSession, Model model) {
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        userInfo.setPersonalDetails(userServiceImp.getPersonalDetails(userInfo));
        userInfo.getPersonalDetails().setEmail(userInfo.getUserName());
        model.addAttribute(userInfo.getPersonalDetails());
        return "profile";
    }
}
