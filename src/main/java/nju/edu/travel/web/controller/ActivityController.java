package nju.edu.travel.web.controller;

import lombok.extern.slf4j.Slf4j;
import nju.edu.travel.entity.Activity;
import nju.edu.travel.service.ActivityService;
import nju.edu.travel.web.vo.ActivityVO;
import nju.edu.travel.web.vo.Message;
import nju.edu.travel.web.wrapper.Activity2ActivityVOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "activityNotStarted/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityNotStarted(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByState(0, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "activityOnGoing/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityOnGoing(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByState(1, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "activityCompleted/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityCompleted(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByState(2, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityNotStartedByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityNotStartedByStuNum(@PathVariable("stuNum") String stuNum,
                                                                   @PathVariable("page") int page,
                                                                   @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, 0, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityOnGoingByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityOnGoingByStuNum(@PathVariable("stuNum") String stuNum,
                                                                @PathVariable("page") int page,
                                                                @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, 1, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }

    @GetMapping(value = "{stuNum}/activityCompletedByStuNum/{page}/{size}")
    public Message<Page<ActivityVO>> getActivityCompletedByStuNum(@PathVariable("stuNum") String stuNum,
                                                                @PathVariable("page") int page,
                                                                @PathVariable("size") int size) {
        Page<Activity> activityPage = activityService.getActivityListPageableByStuNumAndState(stuNum, 2, page, size);
        Page<ActivityVO> activityVOPage = activityPage.map(x -> activity2ActivityVOWrapper.wrapper(x));
        return new Message<>(activityVOPage, 200, "查询成功");
    }
}
