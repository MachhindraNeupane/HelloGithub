/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;
import com.spring.entity.Bookdetails;
import com.spring.entity.Purchaselist;
import java.util.List;
public interface Bookdao { 
      public List<Bookdetails>list(); 
      public boolean insertselectedbook(Purchaselist booklist);
      public List<Object[]> getUserByingList(int userid,String newdate,String databasedate);
      public List<Object[]> getDataBasedate(int userid);  
}
