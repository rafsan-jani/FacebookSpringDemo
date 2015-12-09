package net.therap.facebook.model.dao;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
public interface FacebookDAO {

    void setDataSource(DataSource dataSource);

    List<UserInfo> getAllUserInfo();

    boolean isValidUser(String userName);

    UserInfo makeLogin(UserInfo userInfo);

    PersonalDetails getPersonalDetailsById(int userId);

    boolean addPersonalDetails(UserInfo userInfo);

    boolean addAccount(UserInfo userInfo);

    int getUserId(UserInfo userInfo);

    PersonalDetails getPersonalDetails(UserInfo userInfo);
}
