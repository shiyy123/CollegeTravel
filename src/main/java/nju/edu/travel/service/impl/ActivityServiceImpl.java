package nju.edu.travel.service.impl;

import nju.edu.travel.entity.Activity;
import nju.edu.travel.repository.ActivityRepository;
import nju.edu.travel.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity ifExist(long Id) {
        return activityRepository.findById(Id);
    }
}
