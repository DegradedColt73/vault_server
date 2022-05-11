package pl.vault.vault_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.vault.vault_server.model.Vault;
import pl.vault.vault_server.model.VaultUser;
import pl.vault.vault_server.repository.VaultRepository;
import pl.vault.vault_server.repository.VaultUserRepository;

import java.util.List;

@Service
public class VaultUserService {
    private VaultUserRepository vaultUserRepository;
    private VaultRepository vaultRepository;

    @Autowired
    public VaultUserService(VaultUserRepository vaultUserRepository, VaultRepository vaultRepository) {
        this.vaultUserRepository = vaultUserRepository;
        this.vaultRepository = vaultRepository;
    }

    public Long userId(String username){
        List<VaultUser> vaultUser = this.vaultUserRepository.findByUsername(username);
        return vaultUser.get(0).getId();
    }

    public void insertNewUser(String username, String password){
        final VaultUser vaultUser = new VaultUser();
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        vaultUser.setUsername(username);
        vaultUser.setPassword(bCryptPasswordEncoder.encode(password));
        this.vaultUserRepository.save(vaultUser);
    }

    public List<Vault> getVaults(Long userId){
        return this.vaultRepository.findByUserId(userId);
    }
}
