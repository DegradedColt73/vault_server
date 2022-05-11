package pl.vault.vault_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vault.vault_server.model.Vault;
import pl.vault.vault_server.services.VaultUserService;
import pl.vault.vault_server.util.TokenHolder;

import java.util.List;

@RestController
@RequestMapping("/api/me")
public class VaultUserController {

    private VaultUserService vaultUserService;

    @Autowired
    public VaultUserController(VaultUserService vaultUserService) {
        this.vaultUserService = vaultUserService;
    }

    @GetMapping("/vaults")
    public ResponseEntity<List<Vault>> getUserVaults(){
        TokenHolder tokenHolder = new TokenHolder();
        return ResponseEntity.ok(this.vaultUserService.getVaults(this.vaultUserService.userId(tokenHolder.getUsername())));
    }
}
