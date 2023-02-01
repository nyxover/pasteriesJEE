package com.training.pastries.dao;

import com.training.pastries.dao.entity.Pastry;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{

    Optional<T> get(Long id);

    List<T> getAll();

    T save(T t);

    Pastry update(T t);

    boolean delete(T t);


    List<Pastry> findByName(String searchName);

    List<Pastry> searchPastries(String searchTerm);

}
