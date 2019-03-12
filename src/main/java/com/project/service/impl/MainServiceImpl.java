package com.project.service.impl;

import com.project.mapper.MainMapper;
import com.project.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MainServiceImpl implements MainService {
    @Autowired
    private MainMapper mapper;
    @Override
    public void updateData() {
        System.out.println(mapper);
        mapper.updateDate();
        int i=1/0;


    }
}
