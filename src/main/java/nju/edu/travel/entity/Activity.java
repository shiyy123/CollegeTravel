package nju.edu.travel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_ACTIVITY")
@NoArgsConstructor
public class Activity extends BaseEntity{
    @Column(name = "F_STU_NUM")
    private String stuNum;
    @Column(name = "F_TITLE")
    private String title;

    @Column(name = "F_START_TIME")
    private Date startTime;//注意开始时间在当前时间之后
    @Column(name = "F_END_TIME")
    private Date endTime;//结束时间在开始时间之后
    @Column(name = "F_ENROLL_END_TIME")
    private Date enrollEndTime;//用户报名需要判断当前时间是否在报名截止时间之前

    @Column(name = "F_LOCATION")
    private String location;

    @Column(name = "F_INTRODUCTION")
    private String introduction;

    @Column(name = "F_PERSON_NUM_LIMIT")
    private Long personNumLimit;//用户报名需要判断当前报名人数是否达到了报名人数上限

    @Column(name = "F_PERSON_NUM_CUR", columnDefinition = "INT default 0")
    private Long personNumCur;//当前报名人数

    @Column(name = "F_STATE", columnDefinition = "INT default 0")
    private int state;//0：活动初始状态，1：活动进行中，2：活动已结束

    @Column(name = "F_CREDIT")
    private Long credit;

    @Column(name = "F_RESPONSIBLE_PERSON_PHONE_NUM")
    private String responsiblePersonPhoneNum;

    @Column(name = "F_OTHER")
    private String other;
}
