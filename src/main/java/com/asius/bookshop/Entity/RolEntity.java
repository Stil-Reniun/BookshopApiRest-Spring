package com.asius.bookshop.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    private String nombrol;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "rolusario")
    private Set<UsersRolEntity> rolusuarioentity = new HashSet<>();


    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombrol() {
        return nombrol;
    }

    public void setNombrol(String nombrol) {
        this.nombrol = nombrol;
    }

    public Set<UsersRolEntity> getRolusuarioentity() {
        return rolusuarioentity;
    }

    public void setRolusuarioentity(Set<UsersRolEntity> rolusuarioentity) {
        this.rolusuarioentity = rolusuarioentity;
    }

    public RolEntity(){

    }
}
