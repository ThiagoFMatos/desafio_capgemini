package com.academia.capgemini.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnagramServiceTest {

    @InjectMocks
    private AnagramService anagramService;

    @ParameterizedTest
    @CsvSource(value = {"ovo:2", "ifailuhkqq:3", "desafio:0", "capgemini:2", "xyyx:4"}, delimiter = ':')
    public void testValidLengthPassword(String word, Integer expected) {
        Integer anagramPairCount = anagramService.countAnagramPairs(word);
        Assertions.assertEquals(expected,anagramPairCount);
    }
}
