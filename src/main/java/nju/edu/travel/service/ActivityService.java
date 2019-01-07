package nju.edu.travel.service;

import nju.edu.travel.entity.Activity;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface ActivityService {
    Activity save(Activity activity);
    Activity ifExist(long Id);
}
