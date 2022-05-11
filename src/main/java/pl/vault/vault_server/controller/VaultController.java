package pl.vault.vault_server.controller;

import exceptions.EmptyResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vault.vault_server.model.VaultCredentials;
import pl.vault.vault_server.services.VaultService;
import vault.VaultDoesNotExistException;

import java.sql.SQLException;

//@RestController
//@RequestMapping("/api/vault")
//public class VaultController {
//    private VaultService vaultService;
//
//    @Autowired
//    public VaultController(VaultService vaultService) {
//        this.vaultService = vaultService;
//    }
//
//    @GetMapping("/{path}")
//    public VaultCredentials getConnection(@PathVariable String path) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
//        return this.vaultService.connect(path);
//    }
//}
