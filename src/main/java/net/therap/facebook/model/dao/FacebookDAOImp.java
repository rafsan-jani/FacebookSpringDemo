package net.therap.facebook.model.dao;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.entities.UserInfo;
import net.therap.facebook.utils.IntegerMapper;
import net.therap.facebook.utils.PersonalDetailsMapper;
import net.therap.facebook.utils.UserInfoMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
public class FacebookDAOImp implements FacebookDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public FacebookDAOImp() {

    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        String SQL = "SELECT * FROM account";
        List<UserInfo> userInfos = jdbcTemplate.query(SQL, new UserInfoMapper());
        return userInfos;
    }

    @Override
    public boolean isValidUser(String userName) {
        String SQL = "SELECT * FROM account where email=?";
        try {
            UserInfo userInfo = jdbcTemplate.queryForObject(SQL, new Object[]{userName}, new UserInfoMapper());
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public UserInfo makeLogin(UserInfo userInfo) {
        String SQL = "SELECT * FROM account where email=? and password=?";
        try {
            UserInfo user = jdbcTemplate.queryForObject(SQL, new Object[]{userInfo.getUserName(), userInfo.getPassword()}, new UserInfoMapper());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PersonalDetails getPersonalDetailsById(int userId) {
        String SQL = "SELECT * FROM personal_info where user_id=?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{userId}, new PersonalDetailsMapper());
    }

    @Override
    public boolean addPersonalDetails(UserInfo userInfo) {
        String SQL = "INSERT INTO " +
                "personal_info (user_id, first_name,last_name,sex, date_of_birth,age) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(SQL, userInfo.getUserId(), userInfo.getPersonalDetails().getFirstName(),
                    userInfo.getPersonalDetails().getLastName(), userInfo.getPersonalDetails().getSex(),
                    userInfo.getPersonalDetails().getDob(), userInfo.getPersonalDetails().getAge());
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean addAccount(UserInfo userInfo) {
        String SQL = "INSERT INTO account (email,password) VALUES(?, ?)";
        try {
            jdbcTemplate.update(SQL, userInfo.getUserName(), userInfo.getPassword());
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public int getUserId(UserInfo userInfo) {
        String SQL = "SELECT user_id FROM account where email=? and password=?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{userInfo.getUserName(), userInfo.getPassword()}, new IntegerMapper());
    }

    @Override
    public PersonalDetails getPersonalDetails(UserInfo userInfo) {

        return null;
    }
}
