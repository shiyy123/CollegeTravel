package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.User;
import nju.edu.travel.web.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class User2UserVOWrapper {

    public UserVO wrapper(User user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public User unwrapper(UserVO vo) {
        User user = new User();
        user.setStuNum(vo.getStuNum());
        user.setPassword(vo.getPassword());
        user.setPhoneNum(vo.getPhoneNum());
        return user;
    }
}
