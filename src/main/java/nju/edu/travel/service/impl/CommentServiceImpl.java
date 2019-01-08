package nju.edu.travel.service.impl;

import nju.edu.travel.entity.Comment;
import nju.edu.travel.repository.CommentRepository;
import nju.edu.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Cary on 19-1-8
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
