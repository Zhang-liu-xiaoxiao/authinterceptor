package com.example.demo.controller;

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
    public List<Info> findAll() {
        return infoService.findAll();
    }

    @GetMapping("/{id}")
    public Info findById(@PathVariable Integer id) {
        return infoService.findById(id);
    }

    @PostMapping
    public int create(@RequestBody Info info) {
        return infoService.insert(info);
    }

    @PutMapping
    public int update(@RequestBody Info info) {
        return infoService.update(info);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        return infoService.delete(id);
    }
}
