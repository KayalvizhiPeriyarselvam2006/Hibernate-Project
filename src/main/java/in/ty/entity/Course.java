package in.ty.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int duration;
	@ManyToOne // foreign column
	private Department dept;
	
	
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Student> students;

	
	
	public Course() {
		
	}
	public Course(int courseId, String courseName, int duration) {
	
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCouresName() {
		return courseName;
	}
	public void setCouresName(String couresName) {
		this.courseName = couresName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	
	}
	@Override
	public String toString() {
		return "Course{id="+courseId+"}";
	}
}
