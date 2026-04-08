// package com.nameapi.controller;

// import java.util.List;
// import java.util.Map;
// import java.util.logging.Logger;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.nameapi.model.Person;
// import com.nameapi.service.PersonService;

// import jakarta.validation.constraints.NotBlank;

// /**
//  * All endpoints use request parameters — no request body.
//  *
//  * POST   /api/persons?firstName=John&lastName=Doe   → create
//  * GET    /api/persons                               → list all
//  * GET    /api/persons/{id}                          → get by id
//  * GET    /api/persons/search?query=John             → search
//  * PUT    /api/persons/{id}?firstName=Jane&lastName=Doe → update
//  * DELETE /api/persons/{id}                          → delete
//  */
// @Validated
// @RestController
// @RequestMapping("/api/persons")
// public class PersonController {

//     private static final Logger log = Logger.getLogger(PersonController.class.getName());

//     private final PersonService service;

//     public PersonController(PersonService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<Person> create(
//             @RequestParam @NotBlank String firstName,
//             @RequestParam @NotBlank String lastName) {
//         log.info(String.format("POST /api/persons firstName=%s lastName=%s", firstName, lastName));
//         Person created = service.create(firstName.trim(), lastName.trim());
//         return ResponseEntity.status(HttpStatus.CREATED).body(created);
//     }

//     @GetMapping
//     public ResponseEntity<List<Person>> getAll() {
//         log.info("GET /api/persons");
//         return ResponseEntity.ok(service.getAll());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Person> getById(@PathVariable Long id) {
//         log.info(String.format("GET /api/persons/%d", id));
//         return service.getById(id)
//                 .map(ResponseEntity::ok)
//                 .orElseGet(() -> {
//                     log.warning(String.format("Person id=%d not found", id));
//                     return ResponseEntity.notFound().build();
//                 });
//     }

//     @GetMapping("/search")
//     public ResponseEntity<List<Person>> search(
//             @RequestParam @NotBlank String query) {
//         log.info(String.format("GET /api/persons/search query=%s", query));
//         return ResponseEntity.ok(service.search(query.trim()));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Person> update(
//             @PathVariable Long id,
//             @RequestParam @NotBlank String firstName,
//             @RequestParam @NotBlank String lastName) {
//         log.info(String.format("PUT /api/persons/%d firstName=%s lastName=%s", id, firstName, lastName));
//         return service.update(id, firstName.trim(), lastName.trim())
//                 .map(ResponseEntity::ok)
//                 .orElseGet(() -> {
//                     log.warning(String.format("Person id=%d not found for update", id));
//                     return ResponseEntity.notFound().build();
//                 });
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
//         log.info(String.format("DELETE /api/persons/%d", id));
//         if (service.delete(id)) {
//             return ResponseEntity.ok(Map.of("message", "Person " + id + " deleted"));
//         }
//         return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                 .body(Map.of("message", "Person " + id + " not found"));
//     }
// }
