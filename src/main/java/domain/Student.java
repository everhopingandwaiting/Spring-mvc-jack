package domain;

/**
 * Created by john on 15-9-28.
 */

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


import domain.*;
import org.hibernate.annotations.*;


import java.util.List;
import java.util.Set;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "STUDENTS")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
public class Student implements Serializable {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int ID;
    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    @OneToOne( cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//@Cascade(value = {
////        org.hibernate.annotations.CascadeType.SAVE_UPDATE,
//        org.hibernate.annotations.CascadeType.REMOVE,org.hibernate.annotations.CascadeType.REFRESH,org.hibernate.annotations.CascadeType.MERGE
//        ,org.hibernate.annotations.CascadeType.REPLICATE,org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(name = "NUMBER_ID", nullable = false, unique = true)
//@Column(updatable = false,insertable = false)
    private Number number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLASS_ID")
    private Class aClass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENTS_COURSES", joinColumns = @JoinColumn(name =
            "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name =
            "COURSE_ID"))
    private List<Course> courses;

    //    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "STUDENTS_ROLES", joinColumns = @JoinColumn(name =
//            "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name =
//            "ROLE_ID"))
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isAdmin() {
//        return role.stream().filter(role -> role.getName().equals("admin")).count() > 0;
        return role.getName().equals("admin");
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", number=" + number +
                ", aClass=" + aClass +
                ", courses=" + courses +
                ", role=" + role +
                '}';
    }
}
