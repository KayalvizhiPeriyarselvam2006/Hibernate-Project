package in.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.ty.entity.Course;


public class CourseDao {
	private	EntityManagerFactory emf;



	public CourseDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public String addCourse(Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(course);
		et.commit();
		return "Record Inserted";
		
	}
	
	public 	Course updateCourse(Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		course = em.merge(course);
		et.commit();
		return course;
	}
	public void deleteCourse(Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(course);
		em.remove(course);
		et.commit();
	}

	public Course findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Course.class, id);
		
		
	}
	
	public List<Course> findAllCoursesInDept(int deptId){
		EntityManager em = emf.createEntityManager();
		TypedQuery<Course> result = em.createQuery("select d.courses from Department d where d.departmentId =:deptId" ,Course.class);
		result.setParameter("deptId", deptId);
		return result.getResultList();
		
	}

}
