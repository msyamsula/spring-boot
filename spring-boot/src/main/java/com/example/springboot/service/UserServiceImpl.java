package com.example.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springboot.dao.RoleDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.Role;
import com.example.springboot.entity.User;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    // session and entity manager only used for hibernate query, if you use jpa repository then no need to use entity manager
    @Autowired
    private EntityManager theEntityManager;

    @Autowired
    private UserDao userDao;

    @Autowired 
    private RoleDao roleDao;


    @Override
    // @Transactional // --> no need transactional if you use jpa repository
    public List<User> findall() {
        /**
         * this section is using session and hibernate query
         */
        // Session session = theEntityManager.unwrap(Session.class);

        // String hql = String.format("from User");

        // List<User> ans = session.createQuery(hql, User.class).getResultList();

        // for(User u : ans){
        //     System.out.println(u.getName() + ":");
        //     for(Role r : u.getRoles()){
        //         System.out.println(r.getName());
        //     }
        // }
        // return ans;
        
        /**
         * this section is using jpa repository
         */
        return userDao.findAll();
    }

    @Override
    // @Transactional // --> no need transactional if you use jpa repository
    public void postUser(User user) {
        /**
         * this section is using hibernate query
         */
        // Session session = theEntityManager.unwrap(Session.class);
        // String hql = String.format("from Role r where r.name like '%s'", "%EMPLOYEE%");

        // System.out.println(hql);
        // Role role = session.createQuery(hql, Role.class).getSingleResult();

        // System.out.println(role);

        // System.out.println(role.getId());
        // System.out.println(role.getName());

        // user.addRole(role);
        
        // session.save(user);

        /**
         * this section is using jpa repository
         */

        Role role = roleDao.findById(1).get();
        user.addRole(role);
        userDao.saveAndFlush(user);
    }

    @Override
    @Transactional // --> no need transactional if you use jpa repository
    public List<User> getUserByRole(String role) {
        /**
         * this section is using hibernate query
         */
        Session session = theEntityManager.unwrap(Session.class);

        role = "ROLE_" + role.toUpperCase();

        String hql = String.format("from Role r where r.name = '%s'", role);

        Role r = session.createQuery(hql, Role.class).getSingleResult();

        List<User> ans = r.getUsers();
        return ans;
    }

    @Override
    public User getById(Integer id) {
        /**
         * this use jpa repository, no need transactional
         */
        // System.out.println(id);
        User ans = userDao.findById(id).get();
        // System.out.println(ans);
        return ans;
    }
}
