package pl.vault.vault_server.services;

import exceptions.EmptyResponseException;
import org.springframework.stereotype.Service;
import pl.vault.vault_server.model.VaultCredentials;
import vault.SQLiteHandler;
import vault.VaultDoesNotExistException;

import java.sql.SQLException;


@Service
public class VaultService {
    private SQLiteHandler vaultDriver;
    private String path;

    public VaultCredentials connect(String path) throws VaultDoesNotExistException, SQLException, EmptyResponseException {
        this.path = path;
        vaultDriver = new SQLiteHandler();
        vaultDriver.connectToDatabase(path);
        return new VaultCredentials(vaultDriver.retrieveIv(), vaultDriver.retrieveId(), vaultDriver.retrieveCheckMessage(), vaultDriver.retrieveKey());
    }
}
