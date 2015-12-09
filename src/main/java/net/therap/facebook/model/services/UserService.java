package net.therap.facebook.model.services;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
public interface UserService {
    boolean addUser(UserInfo personalDetails);

    boolean isValidUser(UserInfo userInfo);

    UserInfo makeLogin(UserInfo userInfo);

    PersonalDetails getPersonalDetails(UserInfo userInfo);

    PersonalDetails getPersonalDetailsById(int userId);
}
