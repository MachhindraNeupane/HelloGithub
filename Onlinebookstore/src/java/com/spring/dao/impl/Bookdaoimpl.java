package com.spring.dao.impl;
import com.spring.dao.Bookdao;
import com.spring.entity.Bookdetails;
import com.spring.entity.Purchaselist;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("bookdao")
public class Bookdaoimpl implements Bookdao{
    @Autowired SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Bookdetails>list() {
        List<Bookdetails> list=null;
        try{
        list=sessionFactory.getCurrentSession().createQuery("from Bookdetails").list();    
        }catch(Exception e){
            list=null;
        }
        return list;
    
     }
    @Transactional
    public boolean insertselectedbook(Purchaselist booklist) {
         boolean check=false;
         try {
             sessionFactory.getCurrentSession().save(booklist);
             check=true;
        } catch (Exception e){
             check=false;
        }
         return check;         
    }

    @Override
    @Transactional
    public List<Object[]> getUserByingList(int userid,String newdate,String databasedate) {
     List<Object[]>list=null;
    list=sessionFactory.getCurrentSession().createQuery("SELECT bookname,quantity,price FROM Userdetails\n" +
"INNER JOIN Purchaselist ON Purchaselist.userid=Userdetails.id\n" +
"     INNER JOIN Bookdetails ON Bookdetails.id=Purchaselist.bookid \n" +
"      WHERE Userdetails.id=:userid   ").setParameter("userid",userid).list();
     return list;
    }

    @Override
    @Transactional
    public  List<Object[]> getDataBasedate(int userid){
            List<Object[]>list=null;
             list=sessionFactory.getCurrentSession().createQuery("SELECT bookname,quantity,price FROM Userdetails\n" +
"INNER JOIN Purchaselist ON Purchaselist.userid=Userdetails.id\n" +
"     INNER JOIN Bookdetails ON Bookdetails.id=Purchaselist.bookid \n" +
"      WHERE Userdetails.id=:userid").setParameter("userid",userid).list();
            return list;
     }
  }
