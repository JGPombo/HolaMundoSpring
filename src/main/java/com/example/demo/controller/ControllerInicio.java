package com.example.demo.controller;

import com.example.demo.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControllerInicio {
    @Value("${index.saludo}")
    private String saludoProperties;

    @GetMapping("/")
    public String inicio(Model model) {
        var saludar = "Hola Mundo con Thymeleaf";
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Gomez");
        persona.setTelefono("654321123");
        persona.setEmail("juan@correo.com");

        var persona2 = new Persona();
        persona2.setNombre("Carla");
        persona2.setApellido("Pombo");
        persona2.setTelefono("654344123");
        persona2.setEmail("carla@correo.com");

        var persona3 = new Persona();
        persona3.setNombre("Tania");
        persona3.setApellido("Pombo");
        persona3.setTelefono("678344123");
        persona3.setEmail("tania@correo.com");

        List<Persona> personas = new ArrayList<Persona>();
       /* personas.add(persona);
        personas.add(persona2);
        personas.add(persona3);*/

        // O tambien se puede crear el arrayList de esta manera:

        var listPersonas = Arrays.asList(persona, persona2, persona3);

        model.addAttribute("saludo", saludar);
        model.addAttribute("saludoProperties", saludoProperties);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        model.addAttribute("listaPersonas", listPersonas);
        log.info("Ejecutando el controlador Spring MVC");
        return ("index");
    }

}
