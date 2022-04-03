/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fr.grin.tpcustomerapplication.session;

import fr.grin.tpcustomerapplication.entities.Customer;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RAZANAJATOVO A Toavina
 */
@Stateless
public class CustomerManager {

    @PersistenceContext
    private EntityManager em;
   
   

   
    
// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Customer> getAllCustomers() {
      Query query = em.createNamedQuery("Customer.findAll");
      return query.getResultList();  
    }  
    
        
    public Customer update(Customer customer) {
      return em.merge(customer);  
    } 
    
    /**
     *
     * @param customer
     */
    public void persist(Customer customer) {
      em.persist(customer);
  
    }
    
        public Customer getCustomer(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
    
}
