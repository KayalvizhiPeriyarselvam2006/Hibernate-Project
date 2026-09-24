package in.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import in.ty.entity.Student;

public class StudentDao {

	private	EntityManagerFactory emf;



	public StudentDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public String addStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		return "Record Inserted";
		
	}
	
	public 	Student updateStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		student = em.merge(student);
		et.commit();
		return student;
	}
	public void deleteStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(student);
		em.remove(student);
		et.commit();
	}

	public Student findStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Student.class, id);
		
		
	}

public List<Student> findAllStudentsInCourse(int courseId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Student> result = em.createQuery("select c.students from Course c where c.courseId =:courseId", Student.class);
	result.setParameter("courseId", courseId);
	return result.getResultList();
	
}

}
