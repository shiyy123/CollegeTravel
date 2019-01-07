package nju.edu.travel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_USER_ENROLL_ACTIVITY")
public class UserEnrollActivity extends BaseEntity {
    @Column(name = "F_ACTIVITY_ID")
    private Long activityId;
    @Column(name = "F_STU_NUM")
    private String stuNum;
    @Column(name = "F_CHECK_STATE", columnDefinition = "INT default 0")
    private int checkState;
    @Column(name = "F_REGISTER_BEFORE", columnDefinition = "INT default 0")
    private int registerBefore;
    @Column(name = "F_REGISTER_AFTER", columnDefinition = "INT default 0")
    private int registerAfter;
}
