package nju.edu.travel.web.wrapper;

import nju.edu.travel.entity.Activity;
import nju.edu.travel.web.vo.ActivityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
public class Activity2ActivityVOWrapper {
    public ActivityVO wrapper(Activity activity) {
        ActivityVO activityVO = new ActivityVO();
        BeanUtils.copyProperties(activity, activityVO);

        activityVO.setStartTime(activity.getStartTime().toString("yyyy-MM-dd HH:mm:ss"));
        activityVO.setEndTime(activity.getEndTime().toString("yyyy-MM-dd HH:mm:ss"));
        activityVO.setEnrollEndTime(activity.getEnrollEndTime().toString("yyyy-MM-dd HH:mm:ss"));

        return activityVO;
    }

    public Activity unwrapper(ActivityVO activityVO) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityVO, activity);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            activity.setStartTime(dateFormat.parse(activityVO.getStartTime()));
            activity.setEndTime(dateFormat.parse(activityVO.getEndTime()));
            activity.setEnrollEndTime(dateFormat.parse(activityVO.getEnrollEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return activity;
    }
}
