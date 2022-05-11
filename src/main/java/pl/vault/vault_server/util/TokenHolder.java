package pl.vault.vault_server.util;


import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TokenHolder {
    private Authentication authentication;
    private String username;

    public TokenHolder() {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        this.username = this.authentication.getName();
    }

    public String getUsername() {
        return username;
    }
}
