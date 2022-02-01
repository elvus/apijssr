package com.jsr.api.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class jwtController {
    public String getJWTToken(String username){
        String secretKey = GetSecretKey();
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("jssrJWT")
                .setSubject(username)
                .claim("authorities", 
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, 
                        secretKey.getBytes()).compact();

        return "Bearer "+token;
    }

    public String GetSecretKey() {
        try {
            InputStream input = new FileInputStream(
            System.getProperty("user.dir") + File.separator + "config.properties");
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("SECRET_KEY");
            
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return null;
    }
}