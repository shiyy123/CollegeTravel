package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.Comment;
import nju.edu.travel.web.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Cary on 19-1-8
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class Comment2CommentVOWrapper {
    public CommentVO wrapper(Comment comment) {
        CommentVO commentVO = new CommentVO();
        BeanUtils.copyProperties(comment, commentVO);
        return commentVO;
    }

    public Comment unwrapper(CommentVO commentVO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentVO, comment);
        return comment;
    }
}
