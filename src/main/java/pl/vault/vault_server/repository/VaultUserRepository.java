package pl.vault.vault_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vault.vault_server.model.VaultUser;

import java.util.List;

public interface VaultUserRepository extends JpaRepository<VaultUser, Long> {
    List<VaultUser> findByUsername(String username);
}
