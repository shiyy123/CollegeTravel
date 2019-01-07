package nju.edu.travel.service.impl;

import lombok.Setter;
import nju.edu.travel.entity.User;
import nju.edu.travel.repository.UserRepository;
import nju.edu.travel.service.UserService;
import nju.edu.travel.web.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User ifExist(String stuNum) {
        return userRepository.findByStuNum(stuNum);
    }

    @Override
    public User checkLogIn(String stuNum, String password) {
        return userRepository.findByStuNumAndPassword(stuNum, password);
    }

    @Override
    public User updateUserInfo(UserInfoVO userInfoVO) {
        User user = userRepository.findByStuNum(userInfoVO.getStuNum());
        user.setPhoneNum(userInfoVO.getPhoneNum());
        user.setGender(userInfoVO.getGender());
        user.setAvatarURL(userInfoVO.getAvatarURL());
        user.setNickName(userInfoVO.getNickName());
        return save(user);
    }
}
