package nju.edu.travel.service;

import nju.edu.travel.entity.User;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
public interface UserService {
    User save(User user);
    User ifExist(String stuNum);
    User checkLogIn(String stuNum, String password);
}
