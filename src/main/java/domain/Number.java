package domain;

import java.io.Serializable;

/**
 * Created by john on 15-9-28.
 */

import javax.persistence.*;


@Entity
@Table(name = "NUMBERS")
public class Number implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String prefix;
    private String suffix;

    @OneToOne(mappedBy = "number")
    private Student student;

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Number{" +
                "ID=" + ID +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
