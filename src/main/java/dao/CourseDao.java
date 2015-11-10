package dao;

import domain.Course;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-9-28.
 */
@Transactional
public class CourseDao implements Serializable {
    private HibernateTemplate template;

    @Transactional(readOnly = true)
    public List<Course> findAll() {

        return (List<Course>) template.find("from Course");
    }

    public CourseDao(HibernateTemplate template) {
        this.template = template;
    }

    public void save(Course course) {
        template.save(course);

    }

    public void delete(Course course) {
        template.delete(course);

    }

    public void update(Course course) {
        template.update(course);


    }

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Transactional(readOnly = true)
    public Course findByID(int ID) {
        return template.get(Course.class, ID);
    }
}
