package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;
import dto.Teacher;



public class TeacherDao {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	

	

	public void saveTeacher(Teacher teacher) {
		et.begin();
		em.persist(teacher);
		et.commit();
	}
		
		public Teacher findTeacher(String email) {
			List<Teacher> list = em.createQuery("select x from Teacher x where email=?1").setParameter(1, email)
					.getResultList();
			if (list.isEmpty()) {
				return null;
			} else
				return list.get(0);

		}

		public Teacher findTeacher(long mob) {
			List<Teacher> list = em.createQuery("select x from Teacher x where mobile=?1").setParameter(1, mob)
					.getResultList();
			if (list.isEmpty()) {
				return null;
			} else
				return list.get(0);
	}
	
}
