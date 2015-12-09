package net.therap.facebook.model.services;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;
import net.therap.facebook.model.dao.FacebookDAOImp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
public class UserServiceImp implements UserService {

    @Autowired
    FacebookDAOImp facebookDAOImp;

    public UserServiceImp() {

    }

    @Override
    public boolean addUser(UserInfo userInfo) {

        boolean status = true;
        status = status & facebookDAOImp.addAccount(userInfo);
        userInfo.setUserId(facebookDAOImp.getUserId(userInfo));
        status = status & facebookDAOImp.addPersonalDetails(userInfo);
        return status;
    }

    @Override
    public boolean isValidUser(UserInfo userInfo) {
        return facebookDAOImp.isValidUser(userInfo.getUserName());
    }

    @Override
    public UserInfo makeLogin(UserInfo userInfo) {
        return facebookDAOImp.makeLogin(userInfo);
    }

    @Override
    public PersonalDetails getPersonalDetails(UserInfo userInfo) {
        return facebookDAOImp.getPersonalDetailsById(userInfo.getUserId());
    }

    @Override
    public PersonalDetails getPersonalDetailsById(int userId) {
        return facebookDAOImp.getPersonalDetailsById(userId);
    }

    public List<UserInfo> get() {
        List<UserInfo> tmp = facebookDAOImp.getAllUserInfo();
        tmp.add(new UserInfo("prince", "persia"));
        return tmp;
    }
}
