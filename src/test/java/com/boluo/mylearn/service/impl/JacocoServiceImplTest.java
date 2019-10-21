package com.boluo.mylearn.service.impl;

import com.boluo.mylearn.service.JacocoService;
import org.junit.Test;

import static org.junit.Assert.*;

public class JacocoServiceImplTest {

    private JacocoService jacocoService = new JacocoServiceImpl();

    @Test
    public void add() {

        jacocoService.add(1, 1);
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }
}