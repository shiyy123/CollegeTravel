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
@Table(name = "T_COMMENT")
public class Comment extends BaseEntity{
    @Column(name = "F_USER_ID")
    private Long userID;
    @Column(name = "F_ACTIVITY_ID")
    private Long activityID;
    @Column(name = "F_CREATE_TIME")
    @CreatedDate
    private Timestamp createTime;
    @Column(name = "F_COMMENT_INFO")
    private String commentInfo;
}
