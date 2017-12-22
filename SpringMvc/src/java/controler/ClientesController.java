package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hibernate.entities.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 *
 * @author user
 */

public class ClientesController implements Controller {

    private String viewName;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
          ModelAndView mv=new ModelAndView("clientes");
        String out="RegistroDatos";
     try{
         
         /*Session s=NewHibernateUtil.getSessionFactory().getCurrentSession();
         s.beginTransaction();
         List result=s.createQuery("from cliente").list();
         mv.addObject("clientes",result);
         s.getTransaction().commit();
         s.getTransaction();*/
         
         SessionFactory sf= NewHibernateUtil.getSessionFactory();
         Session s=sf.openSession();
         List<Cliente> cliente=s.createCriteria(Cliente.class).list();
         mv.addObject("clientes",cliente);
         
        
     }catch(HibernateException ex){
         ex.printStackTrace();
     }
     mv.addObject("message",out);
     
     return mv;
    }
    
}
