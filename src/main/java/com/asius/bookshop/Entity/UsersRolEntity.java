package com.asius.bookshop.Entity;

import javax.persistence.*;
@Entity
@Table(name = "userrol")
public class UsersRolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuariorol;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsersEntity usuariorol;
    @ManyToOne
    private RolEntity rolusario;


    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public UsersEntity getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(UsersEntity usuariorol) {
        this.usuariorol = usuariorol;
    }

    public RolEntity getRolusario() {
        return rolusario;
    }

    public void setRolusario(RolEntity rolusario) {
        this.rolusario = rolusario;
    }
}
