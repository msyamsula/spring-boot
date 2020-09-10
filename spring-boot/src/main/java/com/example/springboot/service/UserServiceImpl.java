// package com.example.springboot.service;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.transaction.Transactional;

// import com.example.springboot.entity.Role;
// import com.example.springboot.entity.User;

// import org.hibernate.Session;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private EntityManager theEntityManager;

//     @Override
//     @Transactional
//     public List<User> findall() {
//         Session session = theEntityManager.unwrap(Session.class);

//         String hql = String.format("from User");

//         List<User> ans = session.createQuery(hql, User.class).getResultList();

//         for(User u : ans){
//             System.out.println(u.getName() + ":");
//             for(Role r : u.getRoles()){
//                 System.out.println(r.getName());
//             }
//         }

//         return ans;
//     }

//     @Override
//     @Transactional
//     public void postUser(User user) {
        
//         Session session = theEntityManager.unwrap(Session.class);
//         String hql = String.format("from Role r where r.name like '%s'", "%EMPLOYEE%");

//         System.out.println(hql);
//         Role role = session.createQuery(hql, Role.class).getSingleResult();

//         System.out.println(role);

//         System.out.println(role.getId());
//         System.out.println(role.getName());

//         user.addRole(role);
        
//         session.save(user);
//     }

//     @Override
//     @Transactional
//     public List<User> getUserByRole(String role) {
//         Session session = theEntityManager.unwrap(Session.class);

//         role = "ROLE_" + role.toUpperCase();

//         String hql = String.format("from Role r where r.name = '%s'", role);

//         Role r = session.createQuery(hql, Role.class).getSingleResult();

//         List<User> ans = r.getUsers();
//         return ans;
//     }
// }
