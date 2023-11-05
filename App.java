package com.Exmaple2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Exmaple2.model.Student;

 
public class App 
{
    public static void main( String[] args )
    {
       
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
      Session session=factory.openSession();
      
      try {
    	  Student s1=new Student();
    	  s1.setName("Tej");
    	 s1.setAge(14);
    	 session.beginTransaction();
    	 session.save(s1);
    	 session.getTransaction().commit();
    	 
    	 Student s2=new Student();
    	 s2.setName("varun");
    	 s2.setAge(21);
    	 session.beginTransaction();
    	 session.save(s2);
    	 
    	 session.getTransaction().commit();
      }
      catch(Exception e){
    	  e.printStackTrace();
      }
      finally {
    	  session.close();
    	  factory.close();
      }
    }
}
