package com.academia.capgemini.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceTest {

    @InjectMocks
    private PasswordService passwordService;

    @ParameterizedTest
    @CsvSource(value = {"test:2", "tt:4", "J:5", "Ya3:3", "passwo:0", "password:0"}, delimiter = ':')
    public void testValidLengthPassword(String password, Integer expected) {
        Integer remainingDigits = passwordService.validPassword(password);
        Assertions.assertEquals(expected,remainingDigits);
    }
}
