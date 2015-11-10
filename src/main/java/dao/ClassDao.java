package dao;

import domain.*;
import domain.Class;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-9-28.
 */
@Transactional
public class ClassDao implements Serializable {
    private HibernateTemplate template;


    public ClassDao(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional(readOnly = true)
    public List<Class> findAll() {

        return (List<Class>) template.find("FROM Class");


    }

    public void save(Class aClass) {
        template.save(aClass);
    }

    public void update(Class aClass) {
        template.update(aClass);

    }

    public void delete(Class aClass) {
        template.delete(aClass);

    }

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Transactional(readOnly = true)
    public Class findByID(int ID) {
        return template.get(Class.class, ID);
    }
}
