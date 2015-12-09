package net.therap.facebook.controller;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;
import net.therap.facebook.model.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * @author: rafsan.jani
 * @since: 11/29/15.
 */
@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(new PersonalDetails());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("personalDetails") PersonalDetails personalDetails,
                          BindingResult bindingResult, HttpSession httpSession, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
//        if (!CustomValidator.getInstance().validate(personalDetails)) {
//            model.addAttribute("error", CustomValidator.getInstance().getErrors(personalDetails).toString());
//            return "register";
//        }
        UserInfo userInfo = new UserInfo(personalDetails.getEmail(), personalDetails.getPassword());
        if (userServiceImp.isValidUser(userInfo)) {
            httpSession.setAttribute("userInfo", userInfo);
            userInfo.setPersonalDetails(personalDetails);
            userServiceImp.addUser(userInfo);
            return "redirect:/profile";
        } else {
            model.addAttribute("error", "This email is already used.");
            return "register";
        }
    }

}
