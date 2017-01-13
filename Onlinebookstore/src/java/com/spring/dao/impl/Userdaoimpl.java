/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.dao.impl;
import com.spring.dao.Userdao;
import com.spring.entity.Userdetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("userdao")
public class Userdaoimpl implements Userdao {
      @Autowired 
      SessionFactory sessionFactory;
      @Transactional
    public boolean register(Userdetails user) {
        boolean check=false; 
        
          try{
           sessionFactory.getCurrentSession().save(user);
           check =true;   
          }catch(Exception e){
              
          }
           
             return check;
    }

    @Override
    @Transactional
    public boolean login(String username,String password){
         boolean check=false;
         try{
          Userdao us=(Userdao)sessionFactory.getCurrentSession().createQuery("from Userdetails where username=:username and password=:password")
                     .setParameter("username", username).setParameter("password", password).uniqueResult();
             if(us!=null){
               check=true;
             } 
         }catch(Exception e){
          check=true;   
         }
          return check;
         }

    @Override
    @Transactional
    public Userdetails user(String username, String password) {
        Userdetails user=(Userdetails)sessionFactory.getCurrentSession().createQuery("from Userdetails where username=:username and password=:password")
                .setParameter("username", username).setParameter("password", password).uniqueResult();
               return user;
    
    }
    @Override
    @Transactional
    public boolean validUsername(String username){
          boolean check=true;
          Userdetails user=null;
          try{
      user=(Userdetails)sessionFactory.getCurrentSession().createQuery("from Userdetails where username=:username")
              .setParameter("username", username).uniqueResult();
      if(user!=null){
      check=false;
      }
          }catch(Exception ex){System.out.println(ex);}
                return check;
                        
           }
}
