package domain;

/**
 * Created by john on 15-9-28.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COURSES")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;

    //    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses")
//    @JoinTable(name = "STUDENTS_COURSES", joinColumns =
//
//    @JoinColumn(name = "COURSE_ID"), inverseJoinColumns =
//
//    @JoinColumn(name = "STUDENT_ID"))
    @ManyToMany
    @JoinTable(name = "STUDENTS_COURSES",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    public List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

