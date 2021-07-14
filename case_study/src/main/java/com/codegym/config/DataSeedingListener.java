//package com.codegym.config;
//
//import com.codegym.model.entity.Role;
//import com.codegym.model.entity.User;
//import com.codegym.repository.employee.IRoleRepository;
//import com.codegym.repository.employee.IUserRepository;
//import com.codegym.ultil.EncrypPasswordUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//
///**
// * Seeding data test for table users and roles
// */
//@Component
//public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Autowired
//    private IRoleRepository roleRepository;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        if (roleRepository.findByName("ROLE_ADMIN")==null){
//            roleRepository.save(new Role("ROLE_ADMIN"));
//        }
//        if (roleRepository.findByName("ROLE_MEMBER")==null){
//            roleRepository.save(new Role("ROLE_MEMBER"));
//        }
//        if (roleRepository.findByName("ROLE_MEMBER")==null){
//            roleRepository.save(new Role("ROLE_BLOCK"));
//        }
//
//        //them admin
//        if (userRepository.findByUsername("admin@gmail.com") == null){
//            User admin = new User();
//            admin.setUsername("admin@gmail.com");
//            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
//            HashSet<Role> roles = new HashSet<>();
//            roles.add(roleRepository.findByName("ROLE_ADMIN"));
//            roles.add(roleRepository.findByName("ROLE_MEMBER"));
//            admin.setRoles(roles);
//            userRepository.save(admin);
//        }
//
//        //Them Member
//        if (userRepository.findByUsername("member@gmail.com") == null){
//            User user = new User();
//            user.setUsername("member@gmail.com");
//            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
//            HashSet<Role> roles = new HashSet<>();
//            roles.add(roleRepository.findByName("ROLE_MEMBER"));
//            user.setRoles(roles);
//            userRepository.save(user);
//        }
//    }
//}
