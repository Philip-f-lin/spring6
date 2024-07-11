package com.philip.spring6.autowired.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao Redis...");
    }
}
