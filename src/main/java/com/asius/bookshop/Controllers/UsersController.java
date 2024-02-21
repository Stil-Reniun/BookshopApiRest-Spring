package com.asius.bookshop.Controllers;

import com.asius.bookshop.Entity.RolEntity;
import com.asius.bookshop.Entity.UsersRolEntity;
import com.asius.bookshop.Entity.UsersEntity;
import com.asius.bookshop.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    //@GetMapping (value = "/{idUser}")
    //public UsersEntity getUserById (@PathVariable("idUser") Integer idUser){
       // UsersEntity getIdUser = usersServices.getUserById(idUser);
        //return getIdUser;
        //}
    @GetMapping (value = "/{username}")
    public UsersEntity obtenerUsuario (@PathVariable("username") String username){
        UsersEntity userlocal = new UsersEntity();
        userlocal = usersServices.getUserService(username);
        return userlocal;
    }


    @PostMapping("/register")
    public UsersEntity agregarUsuario (@RequestBody UsersEntity userJsonEntity) throws Exception{
            Set<UsersRolEntity> userRolController =  new HashSet<>();
            RolEntity rol = new RolEntity();
            rol.setIdrol(1);
            rol.setNombrol("User");
            UsersRolEntity userrol = new UsersRolEntity();
            userrol.setUsuariorol(userJsonEntity);
            userrol.setRolusario(rol);
        userRolController.add(userrol);
        return usersServices.saveUserServices(userJsonEntity,userRolController);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<List<UsersEntity>> listarUsuarios() {
        List<UsersEntity> usuarios = usersServices.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }
//    @DeleteMapping("/delete/{idUser}")
//    public void deleteUser(@PathVariable("idUser") Integer idUser){
//        usersServices.deleteUserService(idUser);
//    }
}
