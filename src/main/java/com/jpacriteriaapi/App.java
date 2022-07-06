// The Criteria API is one of the most common ways of constructing queries for entities and their persistent state. It is just an alternative method for defining JPA queries.

//Criteria API defines a platform-independent criteria queries, written in Java programming language. It was introduced in JPA 2.0. The main purpose behind this is to provide a type-safe way to express a query.

package com.jpacriteriaapi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class App 
{
    public static void main( String[] args )
    {


    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	
    	CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    	
    	Root<Student> stud =cq.from(Student.class);
    	
    	CriteriaQuery<Student> select = cq.select(stud);
    	TypedQuery<Student> q = em.createQuery(select);
    	
    	List<Student> list = q.getResultList();
    	
    	System.out.print("Rollno");
    	System.out.println("\t"+"Name");
    	
    	
    	for(Student s:list) {
    		System.out.print(s.getRollno());
    		System.out.println("\t"+s.getName());
    		
    	}
    	em.getTransaction().begin();
    	em.close();
    	emf.close();
    }
}
