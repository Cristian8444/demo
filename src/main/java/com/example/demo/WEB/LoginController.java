package com.example.demo.WEB;

import com.example.demo.ValidationException;
import com.example.demo.db.UserDao;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpSession;
import java.util.EmptyStackException;

@Controller
@RequestMapping("/login")
public class LoginController {

    private int value = 0;

    @Autowired(required = false)
    User user;

    @Autowired(required = false)
    Blog blog;

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    protected String displayLoginForm(){
        return "login";
}

    @RequestMapping(method = RequestMethod.POST)
    protected ModelAndView perfomLogin(HttpSession session, @RequestParam String user,@RequestParam String password){

        ModelAndView mav = new ModelAndView();
        try {
        if( user.equals(userDao.getUsserPasswordByUsserName(user).getUsername())&&password.equals(userDao.getUsserPasswordByUsserName(user).getPassword())){
            session.setAttribute("logged_user",user);
            mav.setViewName("redirect:/blog");
        } else {
            value++;
            String error = "incorrect password ! " + value;
            mav.setViewName("login");
            mav.addObject("error",error);
        }}
        catch ( EmptyResultDataAccessException ex){
            String err ="Username does not exist!";
//                mav.setViewName("/login");
                mav.addObject("error",err);
            }
        return mav;
    }




}
