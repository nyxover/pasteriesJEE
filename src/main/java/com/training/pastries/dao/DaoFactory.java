package com.training.pastries.dao;


public final class DaoFactory {
    public static PastryDao getPastryDao(){
        return new PastryJpaDao();
    }
}
