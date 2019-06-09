package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.exception.NotAuthorizedException;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.service.UserService;
import com.sda4.fred.quiz.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {


	@Autowired
	private UserFormValidator userFormValidator;

    @Autowired
    private UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView authenticateUser(@ModelAttribute("user") User user, ModelMap model) throws NotAuthorizedException {

        User dbUser = userService.getByEmail(user.getEmail());

        if (null == dbUser || false == dbUser.getPassword().equals(user.getPassword())) {
            throw new NotAuthorizedException("User not authorized!");
        }


        model.put("user", dbUser);

        return new ModelAndView("loginSuccessful", model);
    }

    @PostMapping("/logout")
    public ModelAndView logoutUser(ModelMap model) {


        model.put("msg", "You have logged out with success");

        return new ModelAndView("logoutSuccessful", model);
    }


}

