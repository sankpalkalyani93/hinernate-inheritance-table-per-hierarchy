package com.mymaven.hibernateinheritancetypeone;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 

public class TestTypeOne {
 
    public static void main(String [] args){
    String file = "hibernate.cfg.xml";
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure(file).build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
         Transaction t=session.beginTransaction();    
            
            Employee e1=new Employee();   
            e1.setId(02);
            e1.setName("Deepika B");    
                
            Regular_Employee e2=new Regular_Employee();    
            e2.setName("Neelam S");    
            e2.setSalary(12345);    
            e2.setBonus(5);    
                
            Contract_Employee e3=new Contract_Employee();    
            e3.setName("Kalyani S");    
            e3.setPay_per_hour(123465);    
            e3.setContract_duration("15 hours");    
                
            session.save(e1);    
            session.save(e2);    
            session.save(e3);    
                
            t.commit();    
            session.close();    
            System.out.println("success");        
    }  
}
