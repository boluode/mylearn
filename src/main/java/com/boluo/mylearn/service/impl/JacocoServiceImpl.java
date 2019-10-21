package com.boluo.mylearn.service.impl;

import com.boluo.mylearn.service.JacocoService;
import org.springframework.stereotype.Service;

/**
 * @author 李彦龙 liyanlong1@100tal.com
 * @version 1.0
 * @company 好未来-爱智康
 * @program mylearn
 * @description 测试覆盖率测试
 * @create 2019-10-21 11:47
 */
@Service
public class JacocoServiceImpl implements JacocoService {

    public int add(int one, int two) {
        return one + two;
    }

    public int subtract(int one, int two) {
        return one - two;
    }

    public int multiply(int one, int two) {
        return one * two;
    }

    public int divide(int one, int two) {
        if(two == 0) {
            return 0;
        }
        return one / two;
    }
}
