package Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String Name;
    @OneToOne
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        Name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        getStudents().add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        getStudents().remove(student);
        student.getCourses().remove(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}