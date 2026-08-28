package in.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.ty.entity.Address;
import in.ty.entity.Course;
import in.ty.entity.Department;
import in.ty.entity.Student;
import in.ty.entity.Teachers;

public class DepartmentDao {
private	EntityManagerFactory emf;



public DepartmentDao(EntityManagerFactory emf) {
	this.emf = emf;
}

public String addDepartment(Department dept) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	em.persist(dept);
	et.commit();
	return "Record Inserted";
	
}
public Department updateDept(int id, String name, String location) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction(); 
	et.begin();
	Department dept = em.find(Department.class, id);
    if(dept != null) {
      if(name != null) {
        dept.setDepartmentName(name);
    	 
      }
      if(location != null) {
    	  dept.setLocation(location);
      }
      et.begin();
      dept = em.merge(dept);
      et.commit();
      em.close();
    	  
    }
	return dept;
}
public 	Department updateDept(Department dept) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	dept = em.merge(dept);
	et.commit();
	return dept;
}
public void deleteDept(Department dept) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	em.merge(dept);
	em.remove(dept);
	et.commit();
}

public Department findDeptById(int id) {
	EntityManager em = emf.createEntityManager();
	return em.find(Department.class, id);
	
	
}
public List <Department> findAllDepartment() {
	EntityManager em = emf.createEntityManager();
TypedQuery<Department> result = em.createQuery("select d from Department d",Department.class);
return result.getResultList();
}

public List<Course> findAllCoursesInDept(int deptId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Course> result = em.createQuery("select d.courses from Department d where d.departmentId =:deptId" ,Course.class);
	result.setParameter("deptId", deptId);
	return result.getResultList();
	
}
public List<Student> findAllStudentsInCourse(int courseId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Student> result = em.createQuery("select c.students from Course c where c.courseId =:courseId", Student.class);
	result.setParameter("courseId", courseId);
	return result.getResultList();
	
}

public Address findAddressByStudentId(int studentId) {
	EntityManager em = emf.createEntityManager();
	TypedQuery<Address> result = em.createQuery("select s.address from Student s where s.studentId", Address.class);
	result.setParameter("studentId", studentId);
	return result.getSingleResult();
}

public List<Teachers> findAllTeachersForStudent(int studentId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Teachers> result = em.createQuery("select s.teachers from Student s where s.studentId =:studentId", Teachers.class);
	result.setParameter("studentId", studentId);
	return result.getResultList();
}

public List<Student> findAllStudentsForTeacher(int teacherId){
	EntityManager em = emf.createEntityManager();
	TypedQuery<Student> result = em.createQuery("select t.students from Teachers t where t.teacherId =:teacherId", Student.class);
	result.setParameter("teacherId", teacherId);
	return result.getResultList();
}

}
