//package com.example.springtemplate.daos;
//
//import com.example.springtemplate.models.Order;
//import com.example.springtemplate.repositories.UserRestRepository;
////import org.graalvm.compiler.lir.LIRInstruction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//public class UserOrmDao {
//    @Autowired
//    UserRestRepository userRepository;
//    @GetMapping("/orm/users/create/{fn}/{ln}/{un}/{pw}")
//    public User createUser(@PathVariable("fn") String first,
//                            @PathVariable("ln") String last,
//                            @PathVariable("un") String uname,
//                            @PathVariable("pw") String pass) {
//        Order user = new Order(first, last, uname, pass, null,pass,uname);
//        return userRepository.save(user);
//    }
//    @GetMapping("/orm/users/find")
//    public List<Order> findAllUser() { return userRepository.findAllUsers(); }
//    @GetMapping("orm/users/id/{userId}")
//    public Order findUserById(@PathVariable("userId") Integer id) { return userRepository.findUserById(id); }
//    @GetMapping("orm/users/delete/{deleteUserId}")
//    public void deleteUser(@PathVariable("deleteUserId") Integer id) {
//        userRepository.deleteById(id);}
//    @GetMapping("orm/users/update/{userId}/{password}")
//    public Order updateUser(@PathVariable("userId") Integer id,
//                            @PathVariable("password") String newPassword) {
//        Order user = userRepository.findUserById(id);
//        user.setPassword(newPassword);
//        return userRepository.save(user); }
//}
