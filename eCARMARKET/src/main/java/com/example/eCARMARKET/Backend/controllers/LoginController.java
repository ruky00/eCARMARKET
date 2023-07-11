package com.example.eCARMARKET.Backend.controllers;

import java.util.Map;
import java.util.HashMap;

import com.example.eCARMARKET.Backend.security.jwt.AuthResponse;
import com.example.eCARMARKET.Backend.security.jwt.LoginRequest;
import com.example.eCARMARKET.Backend.security.jwt.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.eCARMARKET.Backend.models.User;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.POST, RequestMethod.GET}, allowCredentials = "true")
public class LoginController {

    @Autowired
    private UserLoginService userService;
    
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @CookieValue(name = "accessToken", required = false) String accessToken,
            @CookieValue(name = "refreshToken", required = false) String refreshToken,
            @RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest, accessToken, refreshToken);
    }

    @GetMapping("/getToken")
    public ResponseEntity<String> getValueFromSession() {
        // Retrieve the value from the session
        String value = (String) httpSession.getAttribute("token");

        if (value != null) {
            return ResponseEntity.ok(value);
        } else {
            return ResponseEntity.notFound().build();
    }
}

    /* @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        // Perform authentication logic or any other required operations
        // You can print the values or return them as needed

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Prepare the response data
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("email", email);
        response.put("password", password);

        // You can return a response to the frontend if needed
        return ResponseEntity.ok(response);
    } */

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(
            @CookieValue(name = "refreshToken", required = false) String refreshToken) {
                return userService.refresh(refreshToken);
            }

    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logOut(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(new AuthResponse(AuthResponse.Status.SUCCESS, userService.logout(request, response)));
    }
}