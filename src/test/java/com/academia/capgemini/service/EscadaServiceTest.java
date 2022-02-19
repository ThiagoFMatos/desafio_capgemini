package com.academia.capgemini.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EscadaServiceTest {

    @InjectMocks
    private EscadaService escadaService;

    @Test
    public void testEscadaReturnBody() {
        StringBuilder sb = new StringBuilder();
        sb.append("   *").append(System.lineSeparator()).append("  **").append(System.lineSeparator()).append(" ***").append(System.lineSeparator());
        final String escada = escadaService.getEscada(3);
        Assertions.assertEquals(sb.toString(),escada);
    }
}
