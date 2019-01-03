package nju.edu.travel.service.impl;

import lombok.Setter;
import nju.edu.travel.entity.User;
import nju.edu.travel.repository.UserRepository;
import nju.edu.travel.service.UserService;
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
    public User ifExist(long userId) {
        return userRepository.findById(userId);
    }


}
