package nju.edu.travel.repository;

import nju.edu.travel.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cary on 19-1-8
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(long Id);
}
