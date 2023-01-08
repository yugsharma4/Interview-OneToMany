package com.example.assignment;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 @Column(name = "std_name",nullable = false)
 private String name;

 private int age;
 private String mobileNo;

 @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
 @JsonIgnore
 private List<Laptop> laptops;

}
