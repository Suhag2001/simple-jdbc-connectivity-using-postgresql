package com.springboot.DatabaseConnectivity.repo;

import com.springboot.DatabaseConnectivity.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StdRepoImpl implements StdRepo {
    String url = "jdbc:postgresql://localhost:5432/bootcoding";
    String user = "postgres";
    String password = "suhag";


    @Override
    public Student selectSingle(int id) {
        Student s1 = new Student();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where id='" + id + "'");

            while (rs.next()) {
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setEmail(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return s1;
    }

    @Override
    public List<Student> selectStudent() {

        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                Student s1 = new Student();
                s1.setId(rs.getInt(1));
                s1.setName(rs.getString(2));
                s1.setEmail(rs.getString(3));
                studentList.add(s1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return studentList;
    }


    @Override
    public void insertStudent(Student s1) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('" + s1.getId() + "','" + s1.getName() + "','" + s1.getEmail() + "')");


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public Student updateStudent(Student s1) {

        Student s2 = new Student();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeUpdate("update student set name='" + s1.getName() + "',email='" + s1.getEmail() + "' where id='" + s1.getId() + "'");

            s2 = selectSingle(s1.getId());

        } catch (Exception e) {
            System.out.println(e);
        }
        return s2;

    }

    @Override
    public Boolean deleteStudent(int id) {

        Boolean result = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where id = '" + id + "'");
            if (count > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
