package nju.edu.travel.web.controller;

import lombok.extern.slf4j.Slf4j;
import nju.edu.travel.entity.User;
import nju.edu.travel.service.UserService;
import nju.edu.travel.web.vo.Message;
import nju.edu.travel.web.vo.UserVO;
import nju.edu.travel.web.wrapper.User2UserVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    User2UserVOWrapper user2UserVOWrapper;

    @PostMapping(value = "signUp")
    public Message<UserVO> signUp(@RequestBody UserVO userVO) {
        User user = userService.ifExist(userVO.getStuNum());
        if (user == null) {
            user = user2UserVOWrapper.unwrapper(userVO);
            user = userService.save(user);
            log.info(user.getId().toString());
            userVO = user2UserVOWrapper.wrapper(user);
            return new Message<>(userVO, 200, "用户注册成功");

        } else {
            return new Message<>(userVO, 300, "用户已存在");
        }
    }

    @PostMapping(value = "signIn")
    public Message<UserVO> signIn(@RequestBody UserVO userVO) {
        User user = userService.checkLogIn(userVO.getStuNum(), userVO.getPassword());
        if (user == null) {
            return new Message<>(userVO, 400, "用户名或密码错误");
        } else {
            userVO = user2UserVOWrapper.wrapper(user);
            return new Message<>(userVO, 200, "登录成功");
        }
    }

    @PostMapping(value = "modifyPwd")
    public Message<UserVO> modifyPwd(@RequestBody UserVO userVO) {
        User user = userService.ifExist(userVO.getStuNum());
        if (user == null) {
            return new Message<>(userVO, 500, "不存在此用户");
        } else {
            user = user2UserVOWrapper.unwrapper(userVO);
            user = userService.save(user);
            userVO = user2UserVOWrapper.wrapper(user);
            return new Message<>(userVO, 200, "密码修改成功");
        }
    }
}
