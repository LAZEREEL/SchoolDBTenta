package Entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Anthony Kalkhorani
 */
@Entity
public class Department extends Course {

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

    @OneToMany
    private List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course) {
        getCourseList().add(course);
        courseList.add(course);
    }

    public void removeCourse(Course course) {
        getCourseList().remove(course);
        courseList.remove(course);
    }

    @OneToMany (mappedBy="department", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Teacher> teacherList = new ArrayList<>();
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void addTeacher(Teacher teacher) {
        getTeacherList().add(teacher);
        teacherList.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        getCourseList().remove(teacher);
        teacherList.remove(teacher);
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