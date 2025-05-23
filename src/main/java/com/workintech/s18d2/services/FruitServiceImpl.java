package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.geyByPriceAsc();
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruitOptional=fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new PlantException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruitToDelete = getById(id); // Önce var olup olmadığını kontrol et (yoksa exception atar)
        fruitRepository.delete(fruitToDelete);
        return fruitToDelete;
    }
}