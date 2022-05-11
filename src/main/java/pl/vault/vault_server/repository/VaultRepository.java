package pl.vault.vault_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vault.vault_server.model.Vault;

import java.util.List;

public interface VaultRepository extends JpaRepository<Vault, Long> {
    List<Vault> findByUserId(Long userId);
}
