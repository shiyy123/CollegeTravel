package nju.edu.travel.repository;

import nju.edu.travel.entity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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

    Page<Activity> findByState(int state, Pageable pageable);

    Page<Activity> findById(List<Long> ids, Pageable pageable);
}
