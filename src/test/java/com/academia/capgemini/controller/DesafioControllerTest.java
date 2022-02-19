package com.academia.capgemini.controller;

import com.academia.capgemini.service.AnagramService;
import com.academia.capgemini.service.EscadaService;
import com.academia.capgemini.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DesafioController.class)
public class DesafioControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EscadaService escadaService;

    @MockBean
    private PasswordService passwordService;

    @MockBean
    private AnagramService anagramService;


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 999})
    public void testEscada(int degr) throws Exception {
        mockMvc.perform(get("/escada/"+String.valueOf(degr)))
                .andExpect(status().isOk());
    }

    @Test
    public void testEscadaBad() throws Exception {
        mockMvc.perform(get("/escada/t"))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -5})
    public void testEscadaNegativeValues(int degr) throws Exception {
        mockMvc.perform(get("/escada/"+String.valueOf(degr)))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"password", "test", "t"})
    public void testValidPassword(String password) throws Exception {
        mockMvc.perform(post("/password").content(password))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ovo", "ifailuhkqq"})
    public void testAnagram(String word) throws Exception {
        mockMvc.perform(get("/anagram").content(word))
                .andExpect(status().isOk());
    }
}
