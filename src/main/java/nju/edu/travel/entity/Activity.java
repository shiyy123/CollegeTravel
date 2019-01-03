package nju.edu.travel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

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
    @Column(name = "F_USER_ID")
    private long userID;
    @Column(name = "F_TITLE")
    private String title;
    @Column(name = "F_START_TIME")
    private Timestamp startTime;
    @Column(name = "F_END_TIME")
    private Timestamp endTime;
    @Column(name = "F_ENROLL_END_TIME")
    private Timestamp enrollEndTime;
    @Column(name = "F_LOCATION")
    private String location;
    @Column(name = "F_INTRODUCTION")
    private String introduction;
    @Column(name = "F_PERSON_NUM_LIMIT")
    private Long personNumLimit;
    @Column(name = "F_PERSON_NUM_CUR", columnDefinition = "INT default 0")
    private Long personNumCur;
    @Column(name = "F_STATE", columnDefinition = "INT default 0")
    private int state;
    @Column(name = "F_CREDIT")
    private Long credit;
    @Column(name = "F_RESPONSIBLE_PERSON_PHONE_NUM")
    private String responsiblePersonPhoneNum;
    @Column(name = "F_OTHER")
    private String other;
}
