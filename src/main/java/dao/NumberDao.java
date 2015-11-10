package dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-9-28.
 */
@Transactional
public class NumberDao implements Serializable {
    private HibernateTemplate template;

    @Transactional(readOnly = true)
    public List<Number> findAll() {
        return (List<Number>) template.find("from  Number");
    }

    public void save(Number number) {
        template.save(number);
    }

    public void delete(Number number) {
        template.delete(number);

    }

    public void update(Number number) {
        template.update(number);

    }


    public HibernateTemplate getTemplate() {

        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public NumberDao(HibernateTemplate template) {

        this.template = template;
    }

    @Transactional(readOnly = true)
    public Number findByID(int ID) {
        return template.get(Number.class, ID);
    }
}
