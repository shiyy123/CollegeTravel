package nju.edu.travel.web.vo;

import lombok.Data;

/**
 * Created by Cary on 19-1-6
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
public class UserInfoVO {
    private String stuNum;
    private String phoneNum;
    private String avatarURL;
    private String gender;
    private String nickName;
    private int credit;
}
