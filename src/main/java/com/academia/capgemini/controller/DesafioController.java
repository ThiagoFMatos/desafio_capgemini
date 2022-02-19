package com.academia.capgemini.controller;

import com.academia.capgemini.service.AnagramService;
import com.academia.capgemini.service.EscadaService;
import com.academia.capgemini.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DesafioController {

    @Autowired
	private EscadaService escadaService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private AnagramService anagramService;

    @GetMapping("/escada/{degr}")
    public ResponseEntity<String> getEscada(@PathVariable Integer degr) {
        if (degr < 0) {
            return ResponseEntity.badRequest().body("Invalid Value");
        }
		final String escada = escadaService.getEscada(degr);

		return ResponseEntity.ok().body(escada);
    }

    @PostMapping("/password")
    public ResponseEntity<Integer> validPassword(@RequestBody String password) {
        final Integer addCharacters = passwordService.validPassword(password);
        return ResponseEntity.ok().body(addCharacters);
    }

    @GetMapping("/anagram")
    public ResponseEntity<Integer> countAnagramPair(@RequestBody String word) {
        final int anagramPairCount = anagramService.countAnagramPairs(word);
        return ResponseEntity.ok().body(anagramPairCount);
    }

}
