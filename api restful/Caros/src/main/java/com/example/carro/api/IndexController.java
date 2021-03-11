package com.example.carro.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get(){
        return "Get spting boot";
    }



    /*@GetMapping("/login/{login}/senha/{senha}")
    public String testr(@PathVariable("login") String login, @PathVariable String senha){
        return "Login "+ login + " senha: " + senha;
    }

    @GetMapping("/carros/{id}")
    public String getCarros(@PathVariable("id") Long id){
            return "Carro by id: " + id;
    }

    @GetMapping("carros/tipo/{tipo}")
    public String getCarroByTipo(@PathVariable("tipo") String tipo){
        return "Lista de carros "+ tipo;
    }*/
}
