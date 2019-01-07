package nju.edu.travel.web.controller;

import lombok.extern.slf4j.Slf4j;
import nju.edu.travel.entity.Activity;
import nju.edu.travel.entity.User;
import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.service.ActivityService;
import nju.edu.travel.service.UserEnrollActivityService;
import nju.edu.travel.service.UserService;
import nju.edu.travel.web.vo.*;
import nju.edu.travel.web.wrapper.Activity2ActivityVOWrapper;
import nju.edu.travel.web.wrapper.User2UserInfoVOWrapper;
import nju.edu.travel.web.wrapper.User2UserVOWrapper;
import nju.edu.travel.web.wrapper.UserEnrollActivity2UserEnrollActivityVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @Autowired
    User2UserInfoVOWrapper user2UserInfoVOWrapper;
    @Autowired
    ActivityService activityService;
    @Autowired
    Activity2ActivityVOWrapper activity2ActivityVOWrapper;
    @Autowired
    UserEnrollActivityService userEnrollActivityService;
    @Autowired
    UserEnrollActivity2UserEnrollActivityVOWrapper userEnrollActivity2UserEnrollActivityVOWrapper;

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
            return new Message<>(null, 3000, "用户已存在");
        }
    }

    @PostMapping(value = "signIn")
    public Message<UserVO> signIn(@RequestBody UserVO userVO) {
        User user = userService.checkLogIn(userVO.getStuNum(), userVO.getPassword());
        if (user == null) {
            return new Message<>(userVO, 4000, "用户名或密码错误");
        } else {
            userVO = user2UserVOWrapper.wrapper(user);
            return new Message<>(userVO, 200, "登录成功");
        }
    }

    @PostMapping(value = "updatePwd")
    public Message<UserVO> updatePwd(@RequestBody UserVO userVO) {
        User user = userService.ifExist(userVO.getStuNum());
        if (user == null) {
            return new Message<>(userVO, 5000, "不存在此用户");
        } else {
            user.setPassword(userVO.getPassword());
            user = userService.save(user);
            userVO = user2UserVOWrapper.wrapper(user);
            return new Message<>(userVO, 200, "密码修改成功");
        }
    }

    @GetMapping(value = "info/{stuNum}")
    public Message<UserInfoVO> getUserInfo(@PathVariable("stuNum") String stuNum) {
        User user = userService.ifExist(stuNum);
        if (user == null) {
            return new Message<>(null, 5000, "不存在此用户");
        } else {
            UserInfoVO userInfoVO = user2UserInfoVOWrapper.wrapper(user);
            return new Message<>(userInfoVO, 200, "获取用户信息");
        }
    }

    @PostMapping(value = "updateUserInfo")
    public Message<UserInfoVO> updateUserInfo(@RequestBody UserInfoVO userInfoVO) {
        userInfoVO = user2UserInfoVOWrapper.wrapper(userService.updateUserInfo(userInfoVO));
        return new Message<>(userInfoVO, 200, "修改个人信息成功");
    }

    @PostMapping(value = "createActivity/{stuNum}")
    public Message<ActivityVO> createActivity(@PathVariable("stuNum") String stuNum, @RequestBody ActivityVO activityVO) {
        User user = userService.ifExist(stuNum);
        if (user == null) {
            return new Message<>(null, 5000, "不存在此用户");
        } else if (activityVO.getStartTime().after(activityVO.getEndTime())) {
            return new Message<>(null, 6000, "开始时间应小于结束时间");
        } else if (activityVO.getEnrollEndTime().after(activityVO.getStartTime())) {
            return new Message<>(null, 6000, "报名截止时间应小于开始时间");
        } else {
            Activity activity = activity2ActivityVOWrapper.unwrapper(activityVO);
            activity.setStuNum(stuNum);
            activity = activityService.save(activity);
            activityVO = activity2ActivityVOWrapper.wrapper(activity);
            return new Message<>(activityVO, 200, "活动创建成功");
        }
    }

    @PostMapping(value = "registerActivity/{activityId}")
    public Message<UserEnrollActivityVO> registerActivity(@PathVariable("activityId") long activityId, @RequestBody UserVO userVO) {
        Activity activity = activityService.ifExist(activityId);
        if (activity == null) {
            return new Message<>(null, 7000, "不存在此活动");
        } else {

            UserEnrollActivity userEnrollActivity = userEnrollActivityService.ifExist(activityId, userVO.getStuNum());
            if (userEnrollActivity == null) {
                userEnrollActivity = new UserEnrollActivity();
                long personNumCur = activity.getPersonNumCur();
                long personNumLimit = activity.getPersonNumLimit();
                if (personNumCur >= personNumLimit) {
                    return new Message<>(null, 8000, "人数达到上限，无法报名");
                }
                Date curDate = new Date();
                if (curDate.after(activity.getEnrollEndTime())) {
                    return new Message<>(null, 8000, "超过报名截止时间，无法报名");
                }

                // register num + 1
                activity.setPersonNumCur(personNumCur + 1);
                activityService.save(activity);

                log.info("activity:" + activityId);


                userEnrollActivity.setActivityId(activityId);
                userEnrollActivity.setStuNum(userVO.getStuNum());

                userEnrollActivity = userEnrollActivityService.save(userEnrollActivity);

                UserEnrollActivityVO userEnrollActivityVO =
                        userEnrollActivity2UserEnrollActivityVOWrapper.wrapper(userEnrollActivity);
                return new Message<>(userEnrollActivityVO, 200, "报名活动成功");

            } else {
                return new Message<>(null, 9000, "该用户已报名参加此活动");
            }

        }
    }
}
