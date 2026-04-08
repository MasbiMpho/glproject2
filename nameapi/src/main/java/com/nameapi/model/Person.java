// package com.nameapi.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "persons")
// public class Person {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String firstName;

//     @Column(nullable = false)
//     private String lastName;

//     // Constructors
//     public Person() {}

//     public Person(Long id, String firstName, String lastName) {
//         this.id = id;
//         this.firstName = firstName;
//         this.lastName = lastName;
//     }

//     // Getters and setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getFirstName() {
//         return firstName;
//     }

//     public void setFirstName(String firstName) {
//         this.firstName = firstName;
//     }

//     public String getLastName() {
//         return lastName;
//     }

//     public void setLastName(String lastName) {
//         this.lastName = lastName;
//     }

//     // Builder
//     public static Builder builder() {
//         return new Builder();
//     }

//     public static class Builder {
//         private Long id;
//         private String firstName;
//         private String lastName;

//         public Builder id(Long id) {
//             this.id = id;
//             return this;
//         }

//         public Builder firstName(String firstName) {
//             this.firstName = firstName;
//             return this;
//         }

//         public Builder lastName(String lastName) {
//             this.lastName = lastName;
//             return this;
//         }

//         public Person build() {
//             Person person = new Person();
//             person.id = this.id;
//             person.firstName = this.firstName;
//             person.lastName = this.lastName;
//             return person;
//         }
//     }
// }