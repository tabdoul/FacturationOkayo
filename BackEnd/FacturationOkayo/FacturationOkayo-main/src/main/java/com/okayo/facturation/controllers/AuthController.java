package com.okayo.facturation.controllers;

import com.okayo.facturation.dtos.AuthRequest;
import com.okayo.facturation.dtos.AuthResponse;
import com.okayo.facturation.Security.JwtUtil;
import com.okayo.facturation.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UtilisateurService utilisateurService;

    public AuthController(JwtUtil jwtUtil, UtilisateurService utilisateurService) {
        this.jwtUtil = jwtUtil;
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        if (utilisateurService.authenticate(request.username, request.password)) {
            String token = jwtUtil.generateToken(request.username);
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        utilisateurService.register(request.username, request.password, "USER");
        return ResponseEntity.ok("Utilisateur créé !");
    }
}