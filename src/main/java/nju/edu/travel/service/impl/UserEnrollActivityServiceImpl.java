package nju.edu.travel.service.impl;

import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.repository.UserEnrollActivityRepository;
import nju.edu.travel.service.UserEnrollActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
@Transactional
public class UserEnrollActivityServiceImpl implements UserEnrollActivityService {
    @Autowired
    private UserEnrollActivityRepository userEnrollActivityRepository;

    @Override
    public UserEnrollActivity save(UserEnrollActivity userEnrollActivity) {
        return userEnrollActivityRepository.save(userEnrollActivity);
    }

    @Override
    public UserEnrollActivity ifExist(long activityId, String stuNum) {
        return userEnrollActivityRepository.findByActivityIdAndStuNum(activityId, stuNum);
    }
}
