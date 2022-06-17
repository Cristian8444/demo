package com.example.demo.db;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers(){
        return jdbcTemplate.query("SELECT* FROM USER",
                this::getUser);
    }

    public User getUsserPasswordByUsserName(String username){
        return jdbcTemplate.queryForObject("SELECT * FROM \"USER\"  WHERE USERNAME = '"+ username +"'",
                this::getUser);
    }

    public User getUsserByUsserId(int userid){
        return jdbcTemplate.queryForObject("SELECT * FROM \"USER\"  WHERE USERID = '"+ userid +"'",
                this::getUser);
    }


    private User getUser(ResultSet resultSet,int rowNum) throws SQLException{

        User user = new User();

        user.setId(resultSet.getInt("USERID"));
        user.setUsername(resultSet.getString("USERNAME"));
        user.setPassword(resultSet.getString("PASSWORD"));
        user.setPermission(resultSet.getString("PERMISSION"));
        user.setReadonly(resultSet.getString("READONLY"));

        return user;
    }

    public void addNewUser(User user){
        jdbcTemplate.update("INSERT INTO \"USER\" (USERNAME, PASSWORD, PERMISSION, READONLY)" +
                "VALUES(?,?,?,?)" ,user.getUsername(),user.getPassword(),user.getPermission(),user.getReadonly());

    }

}
