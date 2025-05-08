package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getAllVegetablesSortedByPriceAsc();
    Vegetable getVegetableById(Long id);
    List<Vegetable> getAllVegetablesSortedByPriceDesc();
    Vegetable saveVegetable(Vegetable vegetable);
    List<Vegetable> searchVegetablesByName(String name);
    Vegetable deleteVegetable(Long id);


}