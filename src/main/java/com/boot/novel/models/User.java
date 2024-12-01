//package com.boot.novel.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.mapping.List;
//
//import javax.management.relation.Role;
//import java.util.ArrayList;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="users")
//public class User
//{
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable=false)
//    private String name;
//
//    @Column(nullable=false, unique=true)
//    private String email;
//
//    @Column(nullable=false)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinTable(
//            name="users_roles",
//            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
//            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
//    private List<Role> roles = new ArrayList<>();
//
//}