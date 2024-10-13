package br.com.fiap.smartcity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ctVeagendamento {
    @GetMapping("/veagendamento")
    public String viewagendamento() {return "agendamento";}
}
