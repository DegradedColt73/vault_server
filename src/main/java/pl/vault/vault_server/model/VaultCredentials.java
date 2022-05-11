package pl.vault.vault_server.model;

public class VaultCredentials {
    private String iv;
    private String id;
    private String checkMessage;
    private String encryptedMasterKey;

    public VaultCredentials(String iv, String id, String checkMessage, String encryptedMasterKey) {
        this.iv = iv;
        this.id = id;
        this.checkMessage = checkMessage;
        this.encryptedMasterKey = encryptedMasterKey;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getId() {
        return id;
    }

    public String getEncryptedMasterKey() {
        return encryptedMasterKey;
    }

    public void setEncryptedMasterKey(String encryptedMasterKey) {
        this.encryptedMasterKey = encryptedMasterKey;
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
}
