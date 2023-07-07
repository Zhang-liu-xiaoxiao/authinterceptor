package com.example.demo.service;

import com.example.demo.mapper.InfoMapper;
import com.example.demo.model.Info;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final InfoMapper infoMapper;

    public InfoService(InfoMapper infoMapper) {
        this.infoMapper = infoMapper;
    }

    public List<Info> findAll() {
        return infoMapper.findAll();
    }

    public Info findById(Integer id) {
        return infoMapper.findById(id);
    }

    public int insert(Info info) {
        return infoMapper.insert(info);
    }

    public int update(Info info) {
        return infoMapper.update(info);
    }

    public int delete(Integer id) {
        return infoMapper.delete(id);
    }
}
