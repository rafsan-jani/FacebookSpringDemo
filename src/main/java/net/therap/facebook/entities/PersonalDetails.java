package net.therap.facebook.entities;

//import net.therap.facebook.utils.annotations.NotNull;
//import net.therap.facebook.utils.annotations.Pattern;
//import net.therap.facebook.utils.annotations.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: rafsan.jani
 * @since: 11/26/15.
 */
public class PersonalDetails {
//    @NotEmpty(message = "First name cannot be null")
    @NotEmpty
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[a-zA-Z]+$")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null")
    @Size(min = 3, max = 20, message = "Last Name must be between 3 and 20 characters long.")
    @Pattern(regexp = "[a-zA-Z]+$", message = "Last Name must be alphabetic")
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    private int age;

    @NotEmpty
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}/[0-9]{4}")
    private String dobString;

    @Past
    private Date dob;
    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @NotEmpty
    private String sex;

    public PersonalDetails() {

    }

    public PersonalDetails(String firstName, String lastName, String email, Date dob, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = calculateAge(dob);
        this.dob = dob;
        this.sex = sex;
    }

    private int calculateAge(Date dateOfBirth) {
        Calendar birthDay = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        birthDay.setTime(dateOfBirth);

        int age = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

        if (birthDay.get(Calendar.MONTH) > today.get(Calendar.MONTH)) {
            age--;
        } else if (birthDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                && birthDay.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }

    private Date toDate(String date) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = null;
        try {
            dob = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
        this.setAge(calculateAge(this.dob));
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDobString() {
        return dobString;
    }

    public void setDobString(String dobString) {
        this.dobString = dobString;
        this.setDob(toDate(this.dobString));
    }

    public String toString() {
        List<String> attribs = new ArrayList<>();
        attribs.add("Name: " + firstName + " " + lastName);
        attribs.add("Email: " + email);
        attribs.add("Sex: " + sex);
        attribs.add("Date of Birth: " + dob.toString());
        attribs.add("Age: " + age);
        return attribs.toString();
    }
}