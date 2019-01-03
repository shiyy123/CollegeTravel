package nju.edu.travel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

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
@Table(name = "T_USER_ENROLL_ACTIVITY")
public class UserEnrollActivity extends BaseEntity{
    @Column(name = "F_ACTIVITY_ID")
    private Long activityID;
    @Column(name = "F_USER_ID")
    private Long userID;
    @Column(name = "F_ENROLL_TIME")
    @CreatedDate
    private Timestamp enrollTime;
    @Column(name = "F_CHECK_STATE")
    private int checkState;
    @Column(name = "F_REGISTER_BEFORE")
    private int registerBefore;
    @Column(name = "F_REGISTER_AFTER")
    private int registerAFTER;
}
