package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.entity.JwtRequest;
import com.dialogfinance.cashback.entity.JwtResponse;
import com.dialogfinance.cashback.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        log.info("loin Successfully... ");
        return jwtService.createJwtToken(jwtRequest);
    }
}
