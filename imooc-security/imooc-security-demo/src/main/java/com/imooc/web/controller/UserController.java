package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user){
//        , BindingResult errors
//        if(errors.hasErrors()){
//            errors.getAllErrors().stream().forEach(error-> System.out.println(" error: = [" + error + "]"));
//        }
        System.out.println("user = [" + user + "]");
        user.setId("1");
        return user;
    }

    @PutMapping(value="/{id:\\d+}")
    public User update(@PathVariable(name="id") String idxx, @RequestBody User user){
//        public User update(@PathVariable(name="id") String idxx, @Valid @RequestBody User user, BindingResult errors){
//        System.out.println("user = [" + user + "], idxx = [" + idxx + "], errors = [" + errors + "]");
//        if(errors.hasErrors()){
//            errors.getAllErrors().stream().forEach(error->{
//                FieldError fieldError= (FieldError) error;
//                String message=fieldError.getField()+fieldError.getDefaultMessage();
//                System.out.println(" message: = [" + message + "]");
//            });
//        }
        System.out.println("user = [" + user + "]");
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(size = 17,page = 2,sort = "username,asc") Pageable pageable){
        System.out.println("condition = [" + condition + "]");
        System.out.println(" size = [" + pageable.getPageSize() + "]");
        System.out.println(" page = [" + pageable.getPageNumber() + "]");
        System.out.println(" sort = [" + pageable.getSort() + "]");
        List<User> userList=new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @GetMapping(value="/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name="id") String idxx){
        System.out.println("idxx = [" + idxx + "]");
        System.out.println("进入getInfo服务");
        User user=new User();
        user.setUsername("tom");
        return user;
//        throw new UserNotExistsException(idxx);
//        throw new RuntimeException("run execption");
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable(name="id") String idxx){
        System.out.println("idxx = [" + idxx + "]");
    }

}
