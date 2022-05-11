package pl.vault.vault_server.model;

import javax.persistence.*;

@Entity
@Table(name = "vault")
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "vault_name")
    private String vaultName;

    @Column(name = "vault_custom_name")
    private String vaultCustomName;

    public Vault() {
    }

    public Vault(long id, long userId, String vaultName, String vaultCustomName) {
        this.id = id;
        this.userId = userId;
        this.vaultName = vaultName;
        this.vaultCustomName = vaultCustomName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getVaultName() {
        return vaultName;
    }

    public void setVaultName(String vaultName) {
        this.vaultName = vaultName;
    }

    public String getVaultCustomName() {
        return vaultCustomName;
    }

    public void setVaultCustomName(String vaultCustomName) {
        this.vaultCustomName = vaultCustomName;
    }
}
