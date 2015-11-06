package dao;

import domain.Role;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by john on 15-11-6.
 */
@Transactional
public class RoleDao implements Serializable {

    private HibernateTemplate template;

    public RoleDao(HibernateTemplate template) {
        this.template = template;
    }

    public Role persist(Role role) {
        template.persist(role);
        return role;
    }

    @Transactional
    public Role findByName(String name) {
        List<Role> roles = (List<Role>) template.find("FROM Role WHERE name =?", name);
        return roles.isEmpty() ? null : roles.get(0);

    }

}
