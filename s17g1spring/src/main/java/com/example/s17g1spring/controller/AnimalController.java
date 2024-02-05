package com.example.s17g1spring.controller;

import com.example.s17g1spring.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {
//    @Value("${app.name}")
//    private String name;
//    @Value("${app.age}")
//    private String age;
    private Map<Integer, Animal> animalMap = new HashMap<>();

    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
        animalMap.put(animal.getId(),animal);
        return animalMap.get(animal.getId());
    }

    @GetMapping("/")
    public List<Animal> findAll(){
        return animalMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable int id){
        return animalMap.get(id);
    }

    @PutMapping("/{id}")
    public Animal update(@RequestBody Animal animal,
                         @PathVariable int id){
        animalMap.put(id,new Animal(id, animal.getAnimalName()));
        return animalMap.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal remove(@PathVariable int id){
        Animal animal = animalMap.get(id);
        animalMap.remove(id);
        return animal;
    }
}
