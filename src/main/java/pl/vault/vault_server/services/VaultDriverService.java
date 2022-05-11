package pl.vault.vault_server.services;

import crypt.SQLiteHandlerResponse;
import exceptions.EmptyResponseException;
import org.springframework.stereotype.Service;

import pl.vault.vault_server.model.VaultConfig;
import vault.SQLiteHandler;
import vault.VaultDoesNotExistException;

import java.sql.SQLException;
import java.util.Map;

@Service
public class VaultDriverService {
    private SQLiteHandler vaultDriver;

    public VaultDriverService() {
        this.vaultDriver = new SQLiteHandler();
    }

    public VaultConfig getVaultConfig(String url) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
        this.vaultDriver.connectToDatabase(url + ".db");
        return new VaultConfig(vaultDriver.retrieveId(), vaultDriver.retrieveCheckMessage(), vaultDriver.retrieveIv(), vaultDriver.retrieveKey());
    }

    public Map<Integer, SQLiteHandlerResponse> getVaultEntityNames(String url) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
        this.vaultDriver.connectToDatabase(url + ".db");
        return this.vaultDriver.getEntityNames();
    }
}
