package com.academia.capgemini.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public static final int MINIMUN_SIZE = 6;

    public Integer validPassword(String password) {
        Integer digitosRestantes = 0;

        if (password.length() < MINIMUN_SIZE) {
            digitosRestantes = MINIMUN_SIZE - password.length();
        }
        return digitosRestantes;
    }
}
