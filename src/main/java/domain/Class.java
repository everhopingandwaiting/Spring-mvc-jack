package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-9-28.
 */
@Entity
@Table(name = "CLASSES")

public class Class implements Serializable {

    @Id
    @GeneratedValue
    private int ID;
    private String name;

    @OneToMany(mappedBy = "aClass", fetch = FetchType.EAGER)
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
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
