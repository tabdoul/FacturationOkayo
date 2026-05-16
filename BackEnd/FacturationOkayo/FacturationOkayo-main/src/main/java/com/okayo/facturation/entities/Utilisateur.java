package com.okayo.facturation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "ADMIN", "USER"

    public Utilisateur() {}
    public Utilisateur(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; } public void setUsername(String v) { this.username = v; }
    public String getPassword() { return password; } public void setPassword(String v) { this.password = v; }
    public String getRole() { return role; } public void setRole(String v) { this.role = v; }
}