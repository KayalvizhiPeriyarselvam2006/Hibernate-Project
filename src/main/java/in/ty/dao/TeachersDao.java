package in.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.ty.entity.Teachers;

public class TeachersDao {

	private	EntityManagerFactory emf;



	public  TeachersDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public String addTeachers(Teachers teachers) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(teachers);
		et.commit();
		return "Record Inserted";
		
	}
	
	public 	Teachers updateTeachers(Teachers teachers) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		teachers = em.merge(teachers);
		et.commit();
		return teachers;
	}
	public void deleteTeachers(Teachers teachers) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(teachers);
		em.remove(teachers);
		et.commit();
	}

	public Teachers findTeachersById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Teachers.class, id);
		
		
	}

public List<Teachers> findAllTeachersForStudent(int studentId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Teachers> result = em.createQuery("select s.teachers from Student s where s.studentId =:studentId", Teachers.class);
	result.setParameter("studentId", studentId);
	return result.getResultList();
}


}
