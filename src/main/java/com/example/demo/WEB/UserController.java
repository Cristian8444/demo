package com.example.demo.WEB;


import com.example.demo.ValidationException;
import com.example.demo.db.BlogDao;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class UserController {


    UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayBlogpage(){
        ModelAndView mav = new ModelAndView();

        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addNewUser(){
        ModelAndView mve = new ModelAndView();
        mve.setViewName("new-user");
        return mve;
    }
    @PostMapping("/add")
    public ModelAndView performAddNewUser(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.addNewUser(user);
            modelAndView.setViewName("redirect:/login");
        } catch (ValidationException ex){
            modelAndView.setViewName("new-user");
            modelAndView.addObject("error",ex.getMessage());
        }
return modelAndView;
    }

}
