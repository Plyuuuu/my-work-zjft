package com.zjft.cloud.service.impl;

import com.zjft.cloud.dao.ScoreDao;
import com.zjft.cloud.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/11 11:17
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreDao scoreDao;

    @Override
    public boolean addScore(Map<String, Integer> map) {
        return scoreDao.addScore(map);
    }

    @Override
    public boolean modScore(Map<String, Integer> map) {
        return scoreDao.modScore(map);
    }
}
