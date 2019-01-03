package nju.edu.travel.repository;

import nju.edu.travel.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long Id);
}
