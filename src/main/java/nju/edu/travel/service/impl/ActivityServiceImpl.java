package nju.edu.travel.service.impl;

import nju.edu.travel.entity.Activity;
import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.repository.ActivityRepository;
import nju.edu.travel.repository.UserEnrollActivityRepository;
import nju.edu.travel.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserEnrollActivityRepository userEnrollActivityRepository;

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity ifExist(long Id) {
        return activityRepository.findById(Id);
    }

    @Override
    public Page<Activity> getActivityListPageable(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return activityRepository.findAll(PageRequest.of(page, size, sort));
    }

    @Override
    public Page<Activity> getActivityListPageableByTitleOrIntroduction(String title, String introduction, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return activityRepository.findByTitleLikeOrIntroductionLike(title, introduction, PageRequest.of(page, size, sort));
    }

    @Override
    public Page<Activity> getActivityListPageableByState(int page, int size, int state) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Date cur = new Date();
        if (state == 0) {
            return activityRepository.findByEnrollEndTimeAfter(cur, PageRequest.of(page, size, sort));
        } else if (state == 1) {
            return activityRepository.findByEnrollEndTimeBeforeAndStartTimeAfter(cur, cur, PageRequest.of(page, size, sort));
        } else if (state == 2) {
            return activityRepository.findByStartTimeBeforeAndEndTimeAfter(cur, cur, PageRequest.of(page, size, sort));
        } else if (state == 3) {
            return activityRepository.findByEndTimeBefore(cur, PageRequest.of(page, size, sort));
        }
        return null;
    }

    @Override
    public Page<Activity> getActivityListPageableByStuNumAndState(String stuNum, int page, int size, int state) {
        // 获取该用户所有报名的活动
        List<UserEnrollActivity> userEnrollActivityList = userEnrollActivityRepository.findByStuNum(stuNum);
        List<Long> activityIds = new ArrayList<>();
        for (UserEnrollActivity userEnrollActivity : userEnrollActivityList) {
            activityIds.add(userEnrollActivity.getActivityId());
        }
        //根据Activity表中的状态，分为未开始、进行中、已结束
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Date cur = new Date();
        if (state == 0) {
            return activityRepository.findByIdAndEnrollEndTimeAfter(activityIds, cur, PageRequest.of(page, size, sort));
        } else if (state == 1) {
            return activityRepository.findByIdAndEnrollEndTimeBeforeAndStartTimeAfter(activityIds, cur, cur, PageRequest.of(page, size, sort));
        } else if (state == 2) {
            return activityRepository.findByIdAndStartTimeBeforeAndEndTimeAfter(activityIds, cur, cur, PageRequest.of(page, size, sort));
        } else if (state == 3) {
            return activityRepository.findByIdAndEndTimeBefore(activityIds, cur, PageRequest.of(page, size, sort));
        }
        return null;
    }
}
