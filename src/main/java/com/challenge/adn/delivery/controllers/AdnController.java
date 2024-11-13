package com.challenge.adn.delivery.controllers;

import com.challenge.adn.core.interfaces.Adn;
import com.challenge.adn.delivery.models.AdnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class AdnController {

    private final Adn adnService;

    @Autowired
    public AdnController(Adn adnService) {
        this.adnService = adnService;
    }

    @PostMapping
    public ResponseEntity<String> isMutant(@RequestBody AdnRequest request) {
        String[] dnaArray = request.getDna().toArray(new String[0]);
        boolean isMutant = adnService.isMutant(dnaArray);
        return isMutant ? ResponseEntity.ok("Mutant detected")
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
    }
}
