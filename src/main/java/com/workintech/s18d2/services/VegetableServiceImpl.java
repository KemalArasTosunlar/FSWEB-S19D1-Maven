package com.workintech.s18d2.services;


import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getAllVegetablesSortedByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public Vegetable getVegetableById(Long id) {
        Optional<Vegetable> vegetableOptional=vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        throw new PlantException("Vegetable not found with id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> getAllVegetablesSortedByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable saveVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> searchVegetablesByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable deleteVegetable(Long id) {
        Vegetable vegetableToDelete = getVegetableById(id);// Varlığını kontrol et
        vegetableRepository.delete(vegetableToDelete);
        return vegetableToDelete;
    }
}