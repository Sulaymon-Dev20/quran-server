package com.suyo.quran.entities;

import com.suyo.quran.entities.enums.ThemeEnum;
import com.suyo.quran.models.Language;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(indexes = {@Index(name = "user_index_mail", columnList = "email")})
public class User extends AbsNameEntity implements UserDetails {
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "varchar(20) default 'AUTO'")
    @Enumerated(EnumType.STRING)
    private ThemeEnum theme;
    @Column(columnDefinition = "varchar(5) default 'ALL'")
    @Enumerated(EnumType.STRING)
    private Language language;
    @Column(columnDefinition = "TEXT")
    private String password;
    @Column(columnDefinition = "TEXT")
    private String bookmarks;
    @Column(columnDefinition = "TEXT default '[]'")
    private String textSettings;
    @Column(columnDefinition = "boolean default false")
    private boolean authenticated;
    @Column(length = 6)
    private String code;
    private Timestamp authenticatedTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.authenticated;
    }
}
