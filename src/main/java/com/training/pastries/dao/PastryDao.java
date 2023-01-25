package com.training.pastries.dao;

import com.training.pastries.dao.entity.Pastry;

import java.util.List;

public interface PastryDao extends Dao<Pastry> {

    abstract List<Pastry> searchPastries(String searchTerm);

    List<Pastry> findByName(String searchName);
}
