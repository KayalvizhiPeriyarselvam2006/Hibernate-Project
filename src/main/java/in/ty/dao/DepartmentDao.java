package in.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import in.ty.entity.Department;

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

}
