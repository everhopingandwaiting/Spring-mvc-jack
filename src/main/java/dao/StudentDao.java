package dao;

import domain.*;
import domain.Number;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-9-28.
 *
 * @
 */
@Transactional
public class StudentDao implements Serializable {
    private HibernateTemplate template;

    public StudentDao(HibernateTemplate template) {
        this.template = template;
    }


    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) template.find("from Student");

    }

    public void save(Student student) {
        template.save(student);
    }

    public void delete(Student student
    ) {
        template.delete(student);
    }

    public void update(Student student) {
        System.out.println(student.toString() + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        if (student.getRole() == null) {
            Role role = new Role();
            role.setName("user");
            student.setRole(role);
        }
//        domain.Number number = new Number();
//        number.setID(student.getID());
//        String prefix = student.getNumber().getPrefix();
//        number.setPrefix(prefix);
//        number.setSuffix(student.getNumber().getSuffix());
//
//        student.setNumber(number);
        template.merge(student);
    }

    public void persist(Student student) {
        if (student.getRole() == null) {
            Role role = new Role();
            role.setName("user");
            student.setRole(role);
        }

        template.saveOrUpdate(student);

    }

    @Transactional
    public Student find(int id) {
        return template.get(Student.class, id);
    }

    /**
     * @param selected
     */
    public void delSelectedStudents(Integer[] selected) {
        template.deleteAll(findByIds(selected));
    }

    @Transactional
    public List<Student> findByIds(Integer ids[]) {
        String hql = "from Student stu where stu.id in (:ids)";
        Query query = template.getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameterList("ids", ids);
        return query.list();

    }

    public List<Student> findByUserNameAndPwd(String name, String password) {

        return (List<Student>) template.find("FROM Student stu where stu.name = ? and stu.password = ?", name, password);
    }
}
