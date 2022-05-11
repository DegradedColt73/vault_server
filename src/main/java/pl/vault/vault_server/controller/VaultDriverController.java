package pl.vault.vault_server.controller;

import crypt.SQLiteHandlerResponse;
import exceptions.EmptyResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.vault.vault_server.model.VaultConfig;
import pl.vault.vault_server.services.VaultDriverService;
import vault.VaultDoesNotExistException;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VaultDriverController {

    private VaultDriverService vaultDriverService;

    @Autowired
    public VaultDriverController(VaultDriverService vaultDriverService) {
        this.vaultDriverService = vaultDriverService;
    }

    @GetMapping("/vault/{id}")
    public ResponseEntity<VaultConfig> getVaultConfig(@PathVariable String id) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
        return ResponseEntity.ok(this.vaultDriverService.getVaultConfig(id));
    }

    @GetMapping("/vault/{id}/names")
    public ResponseEntity<Map<Integer, SQLiteHandlerResponse>> getVaultEntityNames(@PathVariable String id) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
        return ResponseEntity.ok(this.vaultDriverService.getVaultEntityNames(id));
    }
}
