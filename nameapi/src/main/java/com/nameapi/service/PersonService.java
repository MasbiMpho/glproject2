// package com.nameapi.service;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.concurrent.atomic.AtomicLong;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;

// import com.nameapi.model.Person;

// @Service
// public class PersonService {

//     // Simple in-memory store (can be replaced with JPA Repository later)
//     private final Map<Long, Person> store = new HashMap<>();
//     private final AtomicLong idGenerator = new AtomicLong(1);

//     public Person create(String firstName, String lastName) {
//         Long id = idGenerator.getAndIncrement();
//         Person person = Person.builder()
//                 .id(id)
//                 .firstName(firstName)
//                 .lastName(lastName)
//                 .build();
//         store.put(id, person);
//         return person;
//     }

//     public List<Person> getAll() {
//         return new ArrayList<>(store.values());
//     }

//     public Optional<Person> getById(Long id) {
//         return Optional.ofNullable(store.get(id));
//     }

//     public List<Person> search(String query) {
//         String q = query.toLowerCase();
//         return store.values().stream()
//                 .filter(p ->
//                         p.getFirstName().toLowerCase().contains(q) ||
//                         p.getLastName().toLowerCase().contains(q))
//                 .collect(Collectors.toList());
//     }

//     public Optional<Person> update(Long id, String firstName, String lastName) {
//         Person existing = store.get(id);
//         if (existing == null) {
//             return Optional.empty();
//         }
//         existing.setFirstName(firstName);
//         existing.setLastName(lastName);
//         return Optional.of(existing);
//     }

//     public boolean delete(Long id) {
//         return store.remove(id) != null;
//     }
// }