package com.munchkin.user.controller;

import com.munchkin.user.dto.UserDto;
import com.munchkin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userValidator")
    private Validator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @PostMapping
    public ResponseEntity<Void> leaveUserInfo(@ModelAttribute @Validated UserDto userDto,
                                        BindingResult bindingResult) throws BindException {

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        System.out.println("gender: " + userDto.getGender());
        System.out.println("body_type: " + userDto.getBodyType());
        System.out.println("height: " + userDto.getHeight());
        userService.addUserInfo(userDto.getGender(), userDto.getBodyType(), userDto.getHeight(),
                userDto.getShoulder(), userDto.getArm());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
