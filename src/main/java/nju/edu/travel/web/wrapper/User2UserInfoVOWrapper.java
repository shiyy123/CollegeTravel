package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.User;
import nju.edu.travel.web.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Cary on 19-1-6
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class User2UserInfoVOWrapper {
    public UserInfoVO wrapper(User user){
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        return userInfoVO;
    }
}
