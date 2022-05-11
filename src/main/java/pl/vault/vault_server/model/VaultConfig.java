package pl.vault.vault_server.model;

public class VaultConfig {
    private String id;
    private String checkMessage;
    private String iv;
    private String masterKey;

    public VaultConfig(String id, String checkMessage, String iv, String masterKey) {
        this.id = id;
        this.checkMessage = checkMessage;
        this.iv = iv;
        this.masterKey = masterKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckMessage() {
        return checkMessage;
    }

    public void setCheckMessage(String checkMessage) {
        this.checkMessage = checkMessage;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }
}
