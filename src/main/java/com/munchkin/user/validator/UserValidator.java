package com.munchkin.user.validator;

import com.munchkin.user.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmpty(errors, "gender", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "bodyType", "field.required");
        if (user.getHeight() == 0) {
            errors.rejectValue("height", "field.required");
        }
    }
}
