package com.example.demo.db;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BlogDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Blog>getBlogBy(int userId){
        return jdbcTemplate.query("SELECT * FROM BLOG WHERE USERID =?",
                this::getBlog,userId);
    }

    public Blog getBlogByUserId (int userid ){
        return jdbcTemplate.queryForObject("select* from blog where userid = "+ userid,
        this::getBlog);
    }


    private Blog getBlog (ResultSet resultSet, int rowNum) throws SQLException{
        Blog blog= new Blog();
        blog.setId(resultSet.getInt("ID"));
        blog.setText(resultSet.getString("TEXT"));
        blog.setUserid(resultSet.getInt("USERID"));

        return blog;
    }

    public void addNewBlog (Blog blog){
        jdbcTemplate.update("INSERT INTO BLOG (TEXT , USERID ) " +
                "VALUES (?,?) ", blog.getText(),blog.getUserid());

    }



}
