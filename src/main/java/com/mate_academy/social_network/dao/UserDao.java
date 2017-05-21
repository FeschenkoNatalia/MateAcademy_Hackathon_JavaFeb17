package com.mate_academy.social_network.dao;

import com.mate_academy.social_network.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    public List<User> getUserByName(String name);

}
