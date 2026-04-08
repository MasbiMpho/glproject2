package com.nameapi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
public class NameController {

    private final Map<Long, String> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    // CREATE
    @PostMapping("/add")
    public String addName(@RequestParam String name) {
        long id = idGenerator.incrementAndGet();
        store.put(id, name);
        return "Stored name '" + name + "' with id " + id;
    }

    // READ
    @GetMapping("/get")
    public String getName(@RequestParam Long id) {
        return store.getOrDefault(id, "Name not found");
    }

    // UPDATE
    @PutMapping("/update")
    public String updateName(@RequestParam Long id, @RequestParam String name) {
        store.put(id, name);
        return "Updated id " + id + " to name '" + name + "'";
    }

    // DELETE
    @DeleteMapping("/delete")
    public String deleteName(@RequestParam Long id) {
        store.remove(id);
        return "Deleted id " + id;
    }
}