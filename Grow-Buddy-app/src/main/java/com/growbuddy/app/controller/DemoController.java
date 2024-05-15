package com.growbuddy.app.controller;

import com.growbuddy.app.entity.Person;
import com.growbuddy.app.repoitory.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome all";
    }


@Autowired
private PersonRepository personRepository;
    @GetMapping("/getAll")
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
