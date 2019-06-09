package com.sda4.fred.quiz.validator;

import com.sda4.fred.quiz.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        if (null == user.getEmail()){
            errors.rejectValue("email", "Email field is mandatory");
        }

        if (null == user.getPassword()){
            errors.rejectValue("password", "Password field is mandatory");
        }
    }

}
