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
        User user = user2UserVOWrapper.unwrapper(userVO);
        user.setGender("1");
        user = userService.save(user);
        log.info(user.getId().toString());

        userVO = user2UserVOWrapper.wrapper(user);
        return new Message<>(userVO, 200, "用户注册成功");
    }
}
