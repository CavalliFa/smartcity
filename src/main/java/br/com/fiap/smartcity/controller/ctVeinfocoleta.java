package br.com.fiap.smartcity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ctVeinfocoleta {
    @GetMapping("/veinfocoleta")
    public String viewinfocoleta() {return "infocoleta";}
}
