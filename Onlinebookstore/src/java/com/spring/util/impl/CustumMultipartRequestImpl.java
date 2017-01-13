
package com.spring.util.impl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.spring.util.CustumMultipartRequest;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Enumeration;

/**
 *
 * @author Mac New
 */
@Repository("custumMultipartRequest")
public class CustumMultipartRequestImpl implements CustumMultipartRequest{
        
    @Autowired HttpServletRequest req;
    @Override
    public MultipartRequest getMultipartRequest() {
          MultipartRequest multipart=null;
          String path=req.getServletContext().getRealPath("")+"\\Resources\\images\\profilepicture";
          try{
              multipart=new MultipartRequest(req, path,3000000, new DefaultFileRenamePolicy());
          }catch(Exception e){
              
          }
         return multipart;
    }

   
    
}


