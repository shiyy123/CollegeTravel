package nju.edu.travel.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */

@Data
@Entity
@Table(name = "T_USER")
public class User extends BaseEntity {
    @Column(name = "F_STU_NUM")
    private String stuNum;
    @Column(name = "F_PHONE_NUM")
    private String phoneNum;
    @Column(name = "F_AVATAR_URL")
    private String avatarURL;
    @Column(name = "F_GENDER")
    private String gender;
    @Column(name = "F_NICKNAME")
    private String nickName;
    @Column(name = "F_CREDIT", columnDefinition = "INT default 0")
    private int credit;
    @Column(name = "F_PASSWORD")
    private String password;
    @Column(name = "F_OPEN_ID")
    private String openID;
    @Column(name = "F_STATE", columnDefinition = "INT default 0")
    private int state; //默认为0：非管理员,1：管理员
    @Column(name = "F_OTHER")
    private String other;
}
