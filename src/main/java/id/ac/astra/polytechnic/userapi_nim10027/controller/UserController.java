package id.ac.astra.polytechnic.userapi_nim10027.controller;

import id.ac.astra.polytechnic.userapi_nim10027.service.UserService;
import id.ac.astra.polytechnic.userapi_nim10027.vo.Result;
import id.ac.astra.polytechnic.userapi_nim10027.vo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService mUserService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id) {
        User user = mUserService.getUser(id);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> userList = mUserService.getUsers();
        return userList;
    }

    @PostMapping("/user")
    public Object saveUser(HttpServletResponse response, @RequestBody User userParam) {
        User user = new User(userParam.getId(), userParam.getUsername());
        boolean isSuccess = mUserService.saveUser(user);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @PutMapping("/user")
    public Object modifyUser(HttpServletResponse response, @RequestBody User userParam) {
        User user = new User(userParam.getId(), userParam.getUsername());
        boolean isSuccess = mUserService.updateUser(user);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @DeleteMapping("/user")
    public Object deleteUser(HttpServletResponse response, @RequestParam("id") int id) {
        boolean isSuccess = mUserService.deleteUser(id);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
}
