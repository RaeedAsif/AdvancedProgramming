package net.codejava.hibernate;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
   private static SessionFactory factory; 
   
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      App ME = new App();

      ME.addStudent(1,"Ihtehsam","Akam","pass","January",new java.util.Date(System.currentTimeMillis()));
      
      /* Update records */
      //ME.updateStudent(199332,"October");

      /* Delete */
      //ME.deleteStudent(199325);
 

      /* List */
      System.out.println("");
      System.out.println("TABLE");
      ME.listStudent();
   }
   
   /* Method to CREATE an employee in the database */
   public void addStudent(int id,String fname, String lname,String pass, String fmonth , java.util.Date cdate){
	   	
	   SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// Create a Student Object
						System.out.println("Creating a new Student Object ...");
						Student tempStudent = new Student(id, fname, lname,pass, fmonth, cdate);

						// Start Transaction
						session.beginTransaction();

						// save the Student object
						System.out.println("Saving the Student ...");
						session.save(tempStudent);

						// commit transaction
						session.getTransaction().commit();
						System.out.println("Done ...");
			

   		

		} finally {
			factory.close();
		}

   }
   
   /* Method to  READ all the employees */
   public void listStudent( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List students = session.createQuery("FROM Student").list(); 
         for (Iterator iterator = students.iterator(); iterator.hasNext();){
            Student stud = (Student) iterator.next();
            System.out.println("ID: " + stud.getStudent_id());
            System.out.println("First Name:" + stud.getFirst_name()); 
            System.out.println("Last Name:" + stud.getLast_name()); 
            System.out.println("Fee Month:" + stud.getFmonth()); 
            System.out.println("Password:" + stud.getPass());
            System.out.println("Date:" + stud.getCdate());
            System.out.println("_________________________________");
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE salary for an employee */
   public void updateStudent(Integer StudentID, String month ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Student employee = (Student)session.get(Student.class, StudentID); 
         employee.setFmonth( month );
		 session.update(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteStudent(Integer stdID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Student std = (Student)session.get(Student.class, stdID); 
         session.delete(std); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}