package nju.edu.travel.repository;

import nju.edu.travel.entity.Activity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    Activity findById(long Id);
}
