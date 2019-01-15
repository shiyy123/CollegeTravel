package nju.edu.travel.service.impl;

import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.repository.UserEnrollActivityRepository;
import nju.edu.travel.service.UserEnrollActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<UserEnrollActivity> getUserEnrollActivityListPageableByActivityId(long activityId, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return userEnrollActivityRepository.findByActivityId(activityId, PageRequest.of(page, size, sort));
    }

    @Override
    public Page<UserEnrollActivity> getUserEnrollActivityListPageableByActivityIdAndCheckState(long activityId, int checkState, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return userEnrollActivityRepository.findByActivityIdAndCheckState(activityId, checkState, PageRequest.of(page, size, sort));
    }

    @Override
    public void checkRegisterStudent(long id, int state) {
        userEnrollActivityRepository.updateUserEnrollActivityBy(id, state);
    }
}
