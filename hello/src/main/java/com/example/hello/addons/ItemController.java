package com.example.hello.addons;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
 
@RestController
@RequestMapping("/items")
public class ItemController {
 
    private final Map<Long, String> items = new LinkedHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);
 
    // GET /items
    @GetMapping
    public Map<Long, String> getAll() {
        return items;
    }
 
    // GET /items/{id}
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        String name = items.get(id);
        return name != null ? ResponseEntity.ok(name) : ResponseEntity.notFound().build();
    }
 
    // POST /items   body: { "name": "foo" }
    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, String> body) {
        long id = counter.getAndIncrement();
        items.put(id, body.get("name"));
        return Map.of("id", id, "name", body.get("name"));
    }
 
    // DELETE /items/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return items.remove(id) != null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}