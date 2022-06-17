package com.example.demo.services;

import com.example.demo.db.BlogDao;
import com.example.demo.db.UserDao;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserDao userDao;

    @Autowired
    BlogDao blogDao;



    public List<User> getUsers(){
        return userDao.getAllUsers();
    }


    public User getBlogByUserId(int userid){
        User user = userDao.getUsserByUsserId(userid);
        List<Blog> blogs= blogDao.getBlogBy(userid);
        user.setBlogs(blogs);
        return user;
    }

    public User getUsserPassByUsserName(String name){
        return userDao.getUsserPasswordByUsserName(name);
    }


    public void addNewUser(User user){
        userDao.addNewUser(user);
    }


}
