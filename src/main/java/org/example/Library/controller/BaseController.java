package org.example.Library.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BaseController<RES,REQ> {


    @PostMapping("/create")
    public RES create(@RequestBody REQ t);

    @GetMapping
    public List<RES> getAll();

    @GetMapping("/{Id}")
    public RES getById(@PathVariable Integer Id) throws Exception;


    @PatchMapping
    public RES update(@RequestBody REQ d) throws Exception;



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id);


}




