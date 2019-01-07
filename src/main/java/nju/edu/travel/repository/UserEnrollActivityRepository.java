package nju.edu.travel.repository;

import nju.edu.travel.entity.UserEnrollActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserEnrollActivityRepository extends CrudRepository<UserEnrollActivity, Long> {
//    Page<UserEnrollActivity> findUserEnrollActivitiesByActivityId(long Id);
    UserEnrollActivity findByActivityIdAndStuNum(long activityId, String stuNm);
}
