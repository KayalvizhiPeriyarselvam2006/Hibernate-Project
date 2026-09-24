package in.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.ty.entity.Address;


public class AddressDao {

	private	EntityManagerFactory emf;



	public AddressDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public String addAddress(Address address) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(address);
		et.commit();
		return "Record Inserted";
		
	}
	
	public Address updateAddress(Address address) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		address = em.merge(address);
		et.commit();
		return address;
	}
	public void deleteAddress(Address address) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(address);
		em.remove(address);
		et.commit();
	}

	public Address findAddressById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Address.class, id);
		
		
	}
	public Address findAddressByStudentId(int studentId) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Address> result = em.createQuery("select s.address from Student s where s.studentId", Address.class);
		result.setParameter("studentId", studentId);
		return result.getSingleResult();
	}

}
