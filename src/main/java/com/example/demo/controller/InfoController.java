package com.example.demo.controller;

import com.example.demo.anotation.AuthControl;
import com.example.demo.enums.AuthLevel;
import com.example.demo.model.Info;
import com.example.demo.service.InfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    @AuthControl(AuthLevel.ROOT)
    public List<Info> findAll() {
        return infoService.findAll();
    }

    @GetMapping("/{id}")
    @AuthControl(AuthLevel.ADMIN)
    public Info findById(@PathVariable Integer id) {
        return infoService.findById(id);
    }

    @PostMapping
    @AuthControl(AuthLevel.ALL)
    public int create(@RequestBody Info info) {
        return infoService.insert(info);
    }

    @PutMapping
    @AuthControl(AuthLevel.ADMIN)
    public int update(@RequestBody Info info) {
        return infoService.update(info);
    }

    @DeleteMapping("/{id}")
    @AuthControl(AuthLevel.ADMIN)
    public int delete(@PathVariable Integer id) {
        return infoService.delete(id);
    }
}
