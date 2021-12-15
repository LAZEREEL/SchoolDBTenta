package Entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Anthony Kalkhorani
 */
@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    private String depName;
    public String getDepName() {
        return depName;
    }
    public void setDepName(String depName) {
        this.depName = depName;
    }

    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany (mappedBy="department", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Teacher> teacherList = new ArrayList<>();
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }










    public Department() {
    }
    public Department(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depName='" + depName + '\'';
    }
}