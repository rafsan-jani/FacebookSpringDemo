package net.therap.facebook.utils;

import net.therap.facebook.entities.PersonalDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: rafsan.jani
 * @since: 12/1/15.
 */
public class PersonalDetailsMapper implements RowMapper<PersonalDetails> {
    @Override
    public PersonalDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName(rs.getString("first_name"));
        personalDetails.setLastName(rs.getString("last_name"));
        personalDetails.setDob(rs.getDate("date_of_birth"));
        personalDetails.setAge(rs.getInt("age"));
        personalDetails.setSex(rs.getString("sex"));
        return personalDetails;
    }
}
