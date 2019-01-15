package nju.edu.travel.repository;

import nju.edu.travel.entity.UserEnrollActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserEnrollActivityRepository extends CrudRepository<UserEnrollActivity, Long> {
    UserEnrollActivity findByActivityIdAndStuNum(long activityId, String stuNm);

    List<UserEnrollActivity> findByStuNum(String stuNum);

    Page<UserEnrollActivity> findByActivityId(long activityId, Pageable pageable);

    Page<UserEnrollActivity> findByActivityIdAndCheckState(long activityId, int checkState, Pageable pageable);

    @Modifying
    @Query("update #{#entityName} r set r.checkState = ?2 where r.id = ?1")
    void updateUserEnrollActivityBy(long id, int state);
}
