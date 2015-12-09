package net.therap.facebook.model.dao;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: rafsan.jani
 * @since: 11/26/15.
 */
public class Database {
    List<UserInfo> registeredUserDb;
    List<PersonalDetails> personalDetailsDb;

    public Database() {
        registeredUserDb = new ArrayList<>();
        personalDetailsDb = new ArrayList<>();
        registeredUserDb.add(new UserInfo("rafsan@gmail.com", "12345"));
        registeredUserDb.add(new UserInfo("babar@gmail.com", "54321"));

        personalDetailsDb.add(new PersonalDetails("Rafsan", "Jani", "rafsan@gmail.com", getDate("30/06/1990"), "male"));
        personalDetailsDb.add(new PersonalDetails("Babar", "Akbar", "babar@gmail.com", getDate("30/06/1990"), "male"));
    }

    private Date getDate(String str) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public boolean makeLogin(UserInfo userInfo) {
        for (UserInfo user : registeredUserDb) {
            if (user.getUserName().equals(userInfo.getUserName())) {
                return true;
            }
        }
        return false;
    }

    public PersonalDetails getPersonalDetails(UserInfo userInfo) {
        for (PersonalDetails person : personalDetailsDb) {
            if (person.getEmail().equals(userInfo.getUserName())) {
                return person;
            }
        }
        return null;
    }

    public boolean addUser(PersonalDetails personalDetails) {
        try {
            UserInfo userInfo = new UserInfo(personalDetails.getEmail(), personalDetails.getPassword());
            registeredUserDb.add(userInfo);
            personalDetailsDb.add(personalDetails);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public boolean isValidUser(String email) {
        for (UserInfo userInfo : registeredUserDb) {
            if (userInfo.getUserName().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
