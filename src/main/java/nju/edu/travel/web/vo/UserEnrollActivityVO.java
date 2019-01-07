package nju.edu.travel.web.vo;

import lombok.Data;

/**
 * Created by Cary on 19-1-7
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
public class UserEnrollActivityVO {
    private Long activityId;
    private String stuNum;
    private int checkState;
    private int registerBefore;
    private int registerAfter;
}
