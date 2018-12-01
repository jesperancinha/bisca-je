package com.jesperancinha.biscaje.service;

import com.jesperancinha.biscaje.entities.User;

import javax.persistence.EntityManager;
import java.util.Date;

public interface BiscaService {
    EntityManager getEntityManager();

    boolean updateUser(User user);

    boolean deleteUser(User user);

    boolean  createUser(String joao, String s, Date date);
}
