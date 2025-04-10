package com.webgoat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

    @GetMapping("/oauth2/authorize")
    public String authorize() {
        // Redirect to the OAuth2 provider's authorization endpoint
        return "redirect:https://auth-server.com/oauth/authorize?client_id=your-client-id&response_type=code&redirect_uri=http://localhost:8080/oauth2/callback&scope=read,write";
    }

    @GetMapping("/oauth2/callback")
    public String callback(@RequestParam("code") String code) {
        // Exchange the authorization code for an access token
        String accessToken = exchangeCodeForToken(code);
        return "Access Token: " + accessToken;
    }

    private String exchangeCodeForToken(String code) {
        // Logic to exchange the authorization code for an access token
        return "dummy-access-token"; // Replace with actual token exchange logic
    }
}