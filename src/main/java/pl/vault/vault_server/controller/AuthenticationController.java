package pl.vault.vault_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.vault.vault_server.model.AuthenticationRequest;
import pl.vault.vault_server.model.AuthenticationResponse;
import pl.vault.vault_server.model.VaultUser;
import pl.vault.vault_server.services.VaultUserDetailsService;
import pl.vault.vault_server.services.VaultUserService;
import pl.vault.vault_server.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private VaultUserDetailsService vaultUserDetailsService;
    private JwtUtil jwtUtil;
    private VaultUserService vaultUserService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, VaultUserDetailsService vaultUserDetailsService, JwtUtil jwtUtil, VaultUserService vaultUserService) {
        this.authenticationManager = authenticationManager;
        this.vaultUserDetailsService = vaultUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.vaultUserService = vaultUserService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = vaultUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody VaultUser vaultUser){
        this.vaultUserService.insertNewUser(vaultUser.getUsername(), vaultUser.getPassword());
        return ResponseEntity.ok("success");
    }
}
