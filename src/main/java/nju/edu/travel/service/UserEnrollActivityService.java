package nju.edu.travel.service;

import nju.edu.travel.entity.UserEnrollActivity;
import org.springframework.data.domain.Page;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserEnrollActivityService {
    UserEnrollActivity save(UserEnrollActivity userEnrollActivity);

    UserEnrollActivity ifExist(long activityId, String stuNum);

    Page<UserEnrollActivity> getUserEnrollActivityListPageableByActivityId(long activityId, int page, int size);

    Page<UserEnrollActivity> getUserEnrollActivityListPageableByActivityIdAndCheckState(long activityId, int checkState, int page, int size);

    void checkRegisterStudent(long id, int state);
}
