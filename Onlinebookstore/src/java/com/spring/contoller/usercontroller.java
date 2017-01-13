package com.spring.contoller;
import com.oreilly.servlet.MultipartRequest;
import com.spring.dao.Bookdao;
import com.spring.dao.Userdao;
import com.spring.entity.Bookdetails;
import com.spring.entity.Purchaselist;
import com.spring.entity.Userdetails;
import com.spring.util.CustumMultipartRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
@Controller
public class usercontroller{
     @Autowired HttpServletRequest request;
     @Autowired CustumMultipartRequest custumMultipartRequest;
     @Autowired Userdao userdao;
     @Autowired HttpSession session;
     @Autowired Bookdao bookdao;
     @RequestMapping("/")
     public String index(){
         return "index";
     }
     @RequestMapping("/register")
      public String register(){
          return "register";
      }
      @RequestMapping(value="/login",method=RequestMethod.POST)
         public String login(Model model,@RequestParam("username") String username,@RequestParam("password") String password){
                 boolean ch=userdao.login(username,password);
                 if(ch){
                     Userdetails user =userdao.user(username, password);
                     session.setAttribute("userid", user.getId());
                     session.setAttribute("username", user.getUsername());
                     session.setAttribute("profilepicture", user.getProfilepicture());
                      //session ma thapna bake nai 6 
                     model.addAttribute("booklist",bookdao.list());
                     return "welcome";
                 }
                 else{
                     model.addAttribute("msg","username or password does not match");
                     return "index";
                 }
         }  
      @RequestMapping(value="/register",method=RequestMethod.POST)
        public String register(Model model){
               MultipartRequest mrequest = custumMultipartRequest.getMultipartRequest();  
               Userdetails user= new Userdetails();               
               String username=mrequest.getParameter("username");
               if(userdao.validUsername(username)){                 
               Enumeration names=mrequest.getFileNames();
               String name=null;
               if(names.hasMoreElements()){
                name=mrequest.getFilesystemName(names.nextElement().toString());
               }
               String firstname = mrequest.getParameter("firstname");
               String lastname= mrequest.getParameter("lastname");
               String gender =  mrequest.getParameter("gender");
               String password = mrequest.getParameter("password");
               String phonenumber= mrequest.getParameter("phonenumber");
               String country = mrequest.getParameter("country");
               String state = mrequest.getParameter("state");
               String city = mrequest.getParameter("city");
               user.setUsername(username);
               user.setFirstname(firstname);
               user.setLastname(lastname);
               user.setGender(gender);
               user.setPassword(password);
               user.setPhonenumber(phonenumber);
               user.setCountry(country);
               user.setState(state);
               user.setCity(city);
               user.setProfilepicture(name);
               boolean check=false;
               check=userdao.register(user);
               if(check){
                   model.addAttribute("msg","registerd sucessfully");
               }else{
                   model.addAttribute("msg","can't registerd ");
               }
               }
               else{
                   //Photo delete garna bake 6 
               model.addAttribute("msg","username already exists");
               }
               return "index";
       }
        @RequestMapping(value="/purchase",method=RequestMethod.POST)
         public String purchaselist(Model model){
              boolean check=false;
              Purchaselist purchaselist=new Purchaselist();
              String bookid[]=request.getParameterValues("bookid");
              String quantity[]=request.getParameterValues("quantity");
              for (int i = 0; i < bookid.length; i++){
                   purchaselist.setBookid(Integer.parseInt(bookid[i]));
                   purchaselist.setQuantity(Integer.parseInt(quantity[i]));
                   purchaselist.setUserid((Integer)session.getAttribute("userid"));
                   check=bookdao.insertselectedbook(purchaselist);
            }
                  if(check){
                      model.addAttribute("msg","update");
                      Date date= new Date();
                      DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
                      String newdate = df.format(date);
                      String  databasedate=null;
             model.addAttribute("byinglist",bookdao.getUserByingList((Integer)session.getAttribute("userid"),newdate,databasedate));
                  }   else{
                      model.addAttribute("msg","can't update");
                  }
                    return "billing";   
         }  
    }
