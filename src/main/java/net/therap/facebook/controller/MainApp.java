package net.therap.facebook.controller;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.utils.CustomValidator;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
//package net.therap.DatabaseApp;
//
//        import org.springframework.jdbc.core.JdbcTemplate;
//
//        import javax.sql.DataSource;
//        import java.util.List;

///**
// * author: rafsan.jani
// * since: 11/24/15.
// */
//public class StudentJDBCTemplate implements StudentDAO {
//    //private DataSource dataSource;
//    private JdbcTemplate jdbcTemplateObject;
//
//    public void setDataSource(DataSource dataSource) {
//        //this.dataSource = dataSource;
//        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//    }
//
//    public void create(String name, Integer age) {
//        String SQL = "insert into Student (name, age) values (?, ?)";
//
//        jdbcTemplateObject.update( SQL, name, age);
//        System.out.println("Created Record Name = " + name + " Age = " + age);
//
//    }
//
//    public Student getStudent(Integer id) {
//        String SQL = "select * from Student where id = ?";
//        Student student = jdbcTemplateObject.queryForObject(SQL,
//                new Object[]{id}, new StudentMapper());
//        return student;
//    }
//
//    public List<Student> listStudents() {
//        String SQL = "select * from Student";
//        List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
//        return students;
//    }
//
//    public void delete(Integer id){
//        String SQL = "delete from Student where id = ?";
//        jdbcTemplateObject.update(SQL, id);
//        System.out.println("Deleted Record with ID = " + id );
//    }
//
//    public void update(Integer id, Integer age){
//        String SQL = "update Student set age = ? where id = ?";
//        jdbcTemplateObject.update(SQL, age, id);
//        System.out.println("Updated Record with ID = " + id );
//        return;
//    }
//
//}
public class MainApp {
    public static void main(String[] args) {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("123");
        personalDetails.setLastName("Jani");
        personalDetails.setEmail("rafsan@gmail.com");
        personalDetails.setDobString("30/06/1990");
        personalDetails.setPassword("hahan");
        personalDetails.setSex("male");
        System.out.println(CustomValidator.getInstance().validate(personalDetails));
    }
}

