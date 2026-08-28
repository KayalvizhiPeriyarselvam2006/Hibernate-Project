package in.ty.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int studentId;
	private String name;
	private String email;
	private long phone;
	private int age;
	
	//@OneToOne(cascade = { CascadeType.MERGE , CascadeType.PERSIST}, fetch = FetchType.LAZY)
	 @OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToOne 
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	
//	@OneToMany
//	private List<Teachers> teacher;
//	
//	
//	public Course getCourse() {
//		return course;
//		
//	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_teacher",
	 joinColumns = @JoinColumn(name = "student_id"),
	 inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	 private List<Teachers> teachers;
	
	public List<Teachers> getTeachers(){
		return teachers;
	}
	
	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}
	
	
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student{id="+studentId+", name="+name+"}";
	}

}
