package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vegetable")
@RestController
public class VegetableController {

    private final VegetableService vegetableService;
    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesSortedByPriceAsc(){
        return vegetableService.getAllVegetablesSortedByPriceAsc();
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesSortedByPriceDesc(){
        return vegetableService.getAllVegetablesSortedByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id){
        return vegetableService.getVegetableById(id);
    }

    @PostMapping
    public Vegetable saveVegetable(@RequestBody Vegetable vegetable){
        return vegetableService.saveVegetable(vegetable);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> searchVegetablesByName(@PathVariable String name){
        return vegetableService.searchVegetablesByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteVegetable(@PathVariable Long id){
        Vegetable vegetable=vegetableService.getVegetableById(id);
        if (vegetable !=null){
            vegetableService.deleteVegetable(id);
        }
        return vegetable;
    }





}