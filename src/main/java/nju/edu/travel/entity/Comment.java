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
@Table(name = "T_COMMENT")
public class Comment extends BaseEntity{
    @Column(name = "F_STU_NUM")
    private String stuNum;
    @Column(name = "F_ACTIVITY_ID")
    private Long activityID;
    @Column(name = "F_COMMENT_INFO")
    private String commentInfo;
}
