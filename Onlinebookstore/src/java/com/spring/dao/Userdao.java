/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.dao;

import com.spring.entity.Userdetails;

/**
 *
 * @author Mac New
 */
public interface Userdao {
     public boolean register(Userdetails user);
     public boolean login(String username,String password);
     public Userdetails user(String username,String password);    
     public boolean validUsername(String username);
}
