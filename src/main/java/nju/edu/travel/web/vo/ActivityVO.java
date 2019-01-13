package nju.edu.travel.web.vo;

import lombok.Data;


/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
public class ActivityVO {
    private Long id;
    private String stuNum;
    private String title;
    private String startTime;
    private String endTime;
    private String enrollEndTime;
    private String location;
    private String introduction;
    private Long personNumLimit;
    private Long personNumCur;
    private int state;
    private Long credit;
    private String responsiblePersonPhoneNum;
    private String other;
}
