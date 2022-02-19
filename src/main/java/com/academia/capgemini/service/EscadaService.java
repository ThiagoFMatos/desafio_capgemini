package com.academia.capgemini.service;

import org.springframework.stereotype.Service;

@Service
public class EscadaService {
    private static final String ASTERISK = "*";
    private static final String SPACE = " ";

    public String getEscada(int degr){
        int indexAsterisk, endIndexAsterisk, endIndexSpace, lin, col;
        StringBuilder sb = new StringBuilder();
        endIndexSpace = degr;
        endIndexAsterisk = 1;
        for (lin = 1; lin <= degr; lin++) {
            for (col = 1; col <= endIndexSpace; col++) {
                System.out.print(SPACE);
                sb.append(SPACE);
            }
            endIndexSpace = endIndexSpace - 1;
            for (indexAsterisk = 1; indexAsterisk <= endIndexAsterisk; indexAsterisk++) {
                System.out.print(ASTERISK);
                sb.append(ASTERISK);
            }
            endIndexAsterisk = endIndexAsterisk + 1;
            System.out.println();
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
