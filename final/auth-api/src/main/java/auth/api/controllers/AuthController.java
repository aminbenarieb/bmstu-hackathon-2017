package auth.api.controllers;

import auth.api.exceptions.FailedPasswordException;
import auth.api.exceptions.LoginNotFoundException;
import auth.api.entity.Token;
import auth.api.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import auth.api.services.AuthService;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @ResponseStatus(value=HttpStatus.UNAUTHORIZED,
            reason="login not found")
    @ExceptionHandler(LoginNotFoundException.class)
    public void loginNotFoundException() {

    }

    @ResponseStatus(value=HttpStatus.UNAUTHORIZED,
            reason="password is not correct")
    @ExceptionHandler(FailedPasswordException.class)
    public void failedPasswordException() {

    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Token getProfile(@RequestBody UserInfo userInfo) {
        return authService.auth(userInfo);
    }

}