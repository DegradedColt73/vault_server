package pl.vault.vault_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.vault.vault_server.model.Vault;
import pl.vault.vault_server.model.VaultUser;
import pl.vault.vault_server.repository.VaultRepository;
import pl.vault.vault_server.repository.VaultUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaultUserDetailsService implements UserDetailsService {

    private VaultUserRepository vaultUserRepository;
    private VaultRepository vaultRepository;

    @Autowired
    public VaultUserDetailsService(VaultUserRepository vaultUserRepository, VaultRepository vaultRepository) {
        this.vaultUserRepository = vaultUserRepository;
        this.vaultRepository = vaultRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<VaultUser> vaultUsers = vaultUserRepository.findByUsername(username);
        VaultUser vaultUser = vaultUsers.get(0);
        List<Vault> vaults = vaultRepository.findByUserId(vaultUser.getId());

        return new User(vaultUser.getUsername(), vaultUser.getPassword(), new ArrayList<>());
    }
}
