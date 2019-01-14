package nju.edu.travel.repository;

import nju.edu.travel.entity.Activity;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    Activity findById(long Id);

    Page<Activity> findAll(Pageable pageable);

    @Query("select r from #{#entityName} r where r.title like CONCAT('%',:title,'%') or r.introduction like CONCAT('%',:introduction,'%')")
    Page<Activity> findByTitleLikeOrIntroductionLike(String title, String introduction, Pageable pageable);

    //报名中
    Page<Activity> findByEnrollEndTimeAfter(Date dateTime, Pageable pageable);

    //报名截止，未开始
    Page<Activity> findByEnrollEndTimeBeforeAndStartTimeAfter(Date dateTime1, Date dateTime2, Pageable pageable);

    //进行中
    Page<Activity> findByStartTimeBeforeAndEndTimeAfter(Date dateTime1, Date dateTime2, Pageable pageable);

    //已结束
    Page<Activity> findByEndTimeBefore(Date dateTime, Pageable pageable);

    Page<Activity> findById(List<Long> ids, Pageable pageable);

    //用户参与，报名中
    Page<Activity> findByIdAndEnrollEndTimeAfter(List<Long> ids, Date dateTime, Pageable pageable);

    //用户参与，报名截止，未开始
    Page<Activity> findByIdAndEnrollEndTimeBeforeAndStartTimeAfter(List<Long> ids, Date dateTime1, Date dateTime2, Pageable pageable);

    //用户参与，进行中
    Page<Activity> findByIdAndStartTimeBeforeAndEndTimeAfter(List<Long> ids, Date dateTime1, Date dateTime2, Pageable pageable);

    //用户参与，已结束
    Page<Activity> findByIdAndEndTimeBefore(List<Long> ids, Date dateTime, Pageable pageable);

    List<Activity> findAll();
}
