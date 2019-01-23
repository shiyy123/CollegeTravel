package nju.edu.travel.service;

import nju.edu.travel.entity.Activity;
import nju.edu.travel.entity.UserEnrollActivity;
import org.springframework.data.domain.Page;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface ActivityService {
    Activity save(Activity activity);

    Activity ifExist(long Id);

    Page<Activity> getActivityListPageable(int page, int size);

    Page<Activity> getActivityListPageableByTitleOrIntroduction(String title, String introduction, int page, int size);

    Page<Activity> getActivityListPageableByState(int page, int size, int state);

    Page<Activity> getActivityListPageableByStuNumAndState(String stuNum, int page, int size, int state);

    Page<Activity> getActivityListPageableByOrganizeStuNum(String stuNum, int page, int size);

    Page<UserEnrollActivity> getActivityListPageableByStuNum(String stuNum, int page, int size);
}
