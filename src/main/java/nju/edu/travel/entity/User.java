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
    @Column(name = "F_NICKNAME")
    private String nickName;
    @Column(name = )
}
