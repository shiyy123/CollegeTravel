package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.UserEnrollActivity;
import nju.edu.travel.web.vo.UserEnrollActivityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class UserEnrollActivity2UserEnrollActivityVOWrapper {
    public UserEnrollActivityVO wrapper(UserEnrollActivity userEnrollActivity) {
        UserEnrollActivityVO userEnrollActivityVO = new UserEnrollActivityVO();
        BeanUtils.copyProperties(userEnrollActivity, userEnrollActivityVO);
        return userEnrollActivityVO;
    }

    public UserEnrollActivity unwrapper(UserEnrollActivityVO userEnrollActivityVO) {
        UserEnrollActivity userEnrollActivity = new UserEnrollActivity();
        BeanUtils.copyProperties(userEnrollActivityVO, userEnrollActivity);
        return userEnrollActivity;
    }
}
