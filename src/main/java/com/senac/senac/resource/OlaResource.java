package com.senac.senac.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OlaResource {
    @RequestMapping(value = "/")
    @ResponseBody
    public String Ola() {
        return "Aplicação Funcionando, atualizado em 02/09";
    }
}
