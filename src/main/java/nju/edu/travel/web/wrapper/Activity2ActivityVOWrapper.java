package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.Activity;
import nju.edu.travel.web.vo.ActivityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class Activity2ActivityVOWrapper {
    public ActivityVO wrapper(Activity activity) {
        ActivityVO activityVO = new ActivityVO();
        BeanUtils.copyProperties(activity, activityVO);
        return activityVO;
    }

    public Activity unwrapper(ActivityVO activityVO) {
        Activity activity=new Activity();
        BeanUtils.copyProperties(activityVO, activity);
        return activity;
    }
}
