package com.example.mission2_v02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class Mission2Controller {
    @Autowired
    private StoreService storeService;

    @GetMapping
    @ResponseBody
    public List<Store> findAll() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Store findById(@PathVariable("id") Long id) {
        return storeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Store newStore) {
        storeService.addNewStore(newStore);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        storeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody Store updatedStore, @PathVariable("id") Long id) {
        storeService.updateById(id, updatedStore);
    }
}
