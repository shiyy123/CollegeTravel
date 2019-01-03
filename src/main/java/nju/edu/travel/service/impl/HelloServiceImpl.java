package nju.edu.travel.service.impl;

import nju.edu.travel.service.HelloService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Cary on 19-1-2
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Transactional
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello";
    }
}
