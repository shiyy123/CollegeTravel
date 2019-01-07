package nju.edu.travel.service;

import nju.edu.travel.entity.UserEnrollActivity;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserEnrollActivityService {
    UserEnrollActivity save(UserEnrollActivity userEnrollActivity);
    UserEnrollActivity ifExist(long activityId, String stuNum);
}
