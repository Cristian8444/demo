package com.example.demo.services;

import com.example.demo.db.BlogDao;
import com.example.demo.db.UserDao;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    UserDao userDao;

    @Autowired
    BlogDao blogDao;

    @Autowired
    JdbcTemplate jdbcTemplate;


    public User getBlogByUserId(int userId){
        User user = userDao.getUsserByUsserId(userId);
        List<Blog> blogs = blogDao.getBlogBy(userId);
        user.setBlogs(blogs);

        return user;
    }

    public Blog getBlogBy(int userId, int blogId){
        for(Blog blog: blogDao.getBlogBy(userId)){
            if(blog.getId()== blogId){
                return blog;
            }
        }
        return null;
    }


    public List<Blog>getAllBlogs(){
        return blogDao.getAllBlogs();
    }


}
