package com.asius.bookshop.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
@Data
public class UsersEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String username;
    private String password;
    private String img;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String perfil;
    private boolean enable = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "usuariorol")
    @JsonIgnore
    private Set<UsersRolEntity> usuariorolentity = new HashSet<>();
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
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autorizacion = new HashSet<>();
        this.usuariorolentity.forEach(usuarioRolEntity -> {
            autorizacion.add(new Authority(usuarioRolEntity.getRolusario().getNombrol()));
        });
        return autorizacion;
    }

    public UsersEntity(){

    }


}
