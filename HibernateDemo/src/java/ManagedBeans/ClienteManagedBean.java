/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Hibernate.Entity.Cliente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author user
 */
@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteManagedBean {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Creates a new instance of ClienteManagedBean
     */
    public ClienteManagedBean() {
        cliente=new Cliente();
    }
    
    public List<Cliente> getClientes(){
        SessionFactory sf= Hibernate.Util.HibernateUtil.getSessionFactory();
        Session ses= sf.openSession();
        List<Cliente> clientes=ses.createCriteria(Cliente.class).list();
        List<Cliente> clientes2=ses.createQuery("from Cliente where id_cliente=1").list();
        return clientes;
    }
    
    public String storeCliente(){
        SessionFactory sf= Hibernate.Util.HibernateUtil.getSessionFactory();
        Session ses= sf.openSession();
        Transaction tr=ses.beginTransaction();
        ses.save(cliente);
        tr.commit();
        return "/Staticas/succes";
    }
    
     public String deleteCliente(){
        SessionFactory sf= Hibernate.Util.HibernateUtil.getSessionFactory();
        Session ses= sf.openSession();
        Transaction tr=ses.beginTransaction();
        ses.delete(cliente);
        tr.commit();
        return "/Staticas/delete";
    }
    
    
}
