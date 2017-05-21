package com.mate_academy.social_network.dao;

import java.util.List;

import java.util.List;

public interface GenericDao<T> {
    T create (T t);
    T read (Class <T> t, Long id);
    T read (T t);
    T update (T t);
    T delete (T t);
    List<T> readAll(Class<T> t);
}
