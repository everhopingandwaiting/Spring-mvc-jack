package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by john on 15-10-16.
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    //    @ManyToMany
//    @JoinTable(name = "STUDENTS_ROLES",
//            joinColumns = @JoinColumn(name = "ROLE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    @OneToOne(mappedBy = "role")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
