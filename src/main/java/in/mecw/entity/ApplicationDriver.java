package in.mecw.entity;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import in.ty.dao.DepartmentDao;
import in.ty.entity.Address;
import in.ty.entity.Course;
import in.ty.entity.Department;
import in.ty.entity.Student;
import in.ty.entity.Teachers;

public class ApplicationDriver {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        DepartmentDao deptDao = new DepartmentDao(emf);
        Department d = new Department();
        d.setDepartmentId(1);
        d.setDepartmentName("CSE");
        d.setLocation("salem");
        List<Course> course = new ArrayList<Course>();
        Course c1 = new Course(1, "DataScience", 4);
        Course c2 = new Course(2, "AIML", 4);
        Course c3 = new Course(3, "OOSE", 4);

        Student s1 = new Student();
        s1.setStudentId(70);
        s1.setName("Kayal");
        s1.setAge(20);
        s1.setEmail("kayal@gmail.com");
        s1.setPhone(7845716293L);
        s1.setCourse(c1);

        Address addr1 = new Address();
        addr1.setAddressId(1);
        addr1.setHouseno("567");
        addr1.setStreet("Kamarajar Street");
        addr1.setCity("Kallakurichi");
        addr1.setState("TamilNadu");
        addr1.setPincode(636001);

        s1.setAddress(addr1);
        addr1.setStudent(s1);

        Teachers t1 = new Teachers();
        t1.setTeacherId(1);
        t1.setTeacherName("Karthika");
        t1.setEmail("karthika@gmail.com");
        t1.setSpecialization("Data Structure");

        Teachers t2 = new Teachers();
        t2.setTeacherId(2);
        t2.setTeacherName("Kavitha");
        t2.setEmail("kavitha@gmail.com");
        t2.setSpecialization("Theory Of Computation");

        List<Teachers> teachersList = new ArrayList<>();
        teachersList.add(t1);
        teachersList.add(t2);

        s1.setTeachers(teachersList);
        List<Student> sList = new ArrayList<>();
        sList.add(s1);
        t1.setStudents(sList);
        t2.setStudents(sList);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);

        c1.setStudents(studentList);

        c1.setDept(d);
        c2.setDept(d);
        c3.setDept(d);
        List<Course> courses1 = new ArrayList<Course>();
        d.setCourses(courses1);

        courses1.add(c1);
        courses1.add(c2);
        courses1.add(c3);

        d.setCourses(courses1);
        deptDao.addDepartment(d);

        //Address a = deptDao.findAddressByStudentId(70);
        //System.out.println("City: " + a.getCity());
    }
}