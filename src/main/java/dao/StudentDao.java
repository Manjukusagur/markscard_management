package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;

public class StudentDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	public void saveStudent(Student student) {
		
		et.begin();
		em.persist(student);
		et.commit();
		
	}
	
	public Student findStudent(String email)
	{
		List<Student> list=em.createQuery("select x from Student x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else
		return list.get(0);
	
	}
	
	public Student findStudent(long mob)
	{
		List<Student> list=em.createQuery("select x from Student x where mobile=?1").setParameter(1, mob).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else
		return list.get(0);
	
	}


}
