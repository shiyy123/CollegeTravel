package nju.edu.travel.web.controller;

import lombok.extern.slf4j.Slf4j;
import nju.edu.travel.entity.Activity;
import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.service.ActivityService;
import nju.edu.travel.web.vo.ActivityVO;
import nju.edu.travel.web.vo.Message;
import nju.edu.travel.web.vo.UserEnrollActivityVO;
import nju.edu.travel.web.wrapper.Activity2ActivityVOWrapper;
import nju.edu.travel.web.wrapper.UserEnrollActivity2UserEnrollActivityVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cary on 19-1-8
 * Email: yangyangshi@smail.nju.edu.cn
 */
@RestController
@RequestMapping(value = "activity")
@Slf4j
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @Autowired
    Activity2ActivityVOWrapper activity2ActivityVOWrapper;
    @Autowired
    UserEnrollActivity2UserEnrollActivityVOWrapper userEnrollActivity2UserEnrollActivityVOWrapper;

    @GetMapping(value = "list/{page}/{size}")
    public Message<Page<ActivityVO>> listActivity(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageable(page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "获取活动列表成功");
    }

    @GetMapping(value = "activityInfo/{activityId}")
    public Message<ActivityVO> getActivityInfo(@PathVariable("activityId") long activityId) {
        Activity activity = activityService.ifExist(activityId);
        if (activity == null) {
            return new Message<>(null, 3001, "不存在此活动");
        } else {
            ActivityVO activityVO = activity2ActivityVOWrapper.wrapper(activity);
            return new Message<>(activityVO, 200, "活动详请查询成功");
        }
    }

    @GetMapping(value = "search/{keyword}/{page}/{size}")
    public Message<Page<ActivityVO>> searchByKeyWord(@PathVariable("keyword") String keyword,
                                                     @PathVariable("page") int page,
                                                     @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByTitleOrIntroduction(keyword, keyword, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    //获取三种状态的活动，返回给前端state字段在wrapper函数中处理
    private Message<Page<ActivityVO>> getPageMessage(int page, int size, int state) {
        Page<Activity> activityPage = activityService.getActivityListPageableByState(page, size, state);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "activityRegistering/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityRegistering(@PathVariable("page") int page, @PathVariable("size") int size) {
        return getPageMessage(page, size, 0);
    }

    @GetMapping(value = "activityNotStarted/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityNotStarted(@PathVariable("page") int page, @PathVariable("size") int size) {
        return getPageMessage(page, size, 1);
    }

    @GetMapping(value = "activityOnGoing/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityOnGoing(@PathVariable("page") int page, @PathVariable("size") int size) {
        return getPageMessage(page, size, 2);
    }

    @GetMapping(value = "activityCompleted/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityCompleted(@PathVariable("page") int page, @PathVariable("size") int size) {
        return getPageMessage(page, size, 3);
    }

    @GetMapping(value = "{stuNum}/activityRegisteringByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityRegisteringByStuNum(@PathVariable("stuNum") String stuNum,
                                                                    @PathVariable("page") int page,
                                                                    @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, page, size, 0);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityNotStartedByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityNotStartedByStuNum(@PathVariable("stuNum") String stuNum,
                                                                   @PathVariable("page") int page,
                                                                   @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, page, size, 1);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityOnGoingByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityOnGoingByStuNum(@PathVariable("stuNum") String stuNum,
                                                                @PathVariable("page") int page,
                                                                @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, page, size, 2);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityCompletedByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityCompletedByStuNum(@PathVariable("stuNum") String stuNum,
                                                                  @PathVariable("page") int page,
                                                                  @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, page, size, 3);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activitiesByStuNum/{page}/{size}")
    public Message<Page<UserEnrollActivityVO>> getActivitiesByStuNum(@PathVariable("stuNum") String stuNum,
                                                           @PathVariable("page") int page,
                                                           @PathVariable("size") int size) {
        Page<UserEnrollActivity> userEnrollActivityPage = activityService.getActivityListPageableByStuNum(stuNum, page, size);
        Page<UserEnrollActivityVO> userEnrollActivityVOPage = userEnrollActivityPage.map(x -> userEnrollActivity2UserEnrollActivityVOWrapper.wrapper(x));
        return new Message<>(userEnrollActivityVOPage, 200, "查询成功");
    }
}
