package net.therap.facebook.entities;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author: rafsan.jani
 * @since: 11/25/15.
 */
public class UserInfo {

    private int userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;

    private PersonalDetails personalDetails;

    public UserInfo() {
    }

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String toString(UserInfo user) {
        String str = user.getUserName();
        return str;
    }
}