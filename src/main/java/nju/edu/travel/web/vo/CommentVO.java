package nju.edu.travel.web.vo;

import lombok.Data;

/**
 * Created by Cary on 19-1-8
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
public class CommentVO {
    private Long id;
    private String stuNum;
    private Long activityID;
    private String commentInfo;
}
