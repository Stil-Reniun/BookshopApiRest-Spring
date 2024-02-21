package com.asius.bookshop.Services.implement;

import com.asius.bookshop.Entity.UsersRolEntity;
import com.asius.bookshop.Entity.UsersEntity;
import com.asius.bookshop.Repository.RolRepository;
import com.asius.bookshop.Repository.UsersRepository;
import com.asius.bookshop.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public UsersEntity saveUserServices(UsersEntity usuariosJson, Set<UsersRolEntity> usuarioRolController) throws Exception {

        UsersEntity userlocal = userRepository.findByUsername(usuariosJson.getUsername());
        if (userlocal != null) {
            System.out.println("User already exists");
        } else {
            for(UsersRolEntity usersRolEntity :usuarioRolController){
                rolRepository.save(usersRolEntity.getRolusario());
            }
            usuariosJson.getUsuariorolentity().addAll(usuarioRolController);
            userlocal = userRepository.save(usuariosJson);
        }
        return userlocal;
    }

    @Override
    public UsersEntity getUserService(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserService(Integer idUser) {
        UsersEntity user = new UsersEntity();
        user.setIdUser(idUser);
        userRepository.delete(user);
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity getUserById(Integer idUser) {
        return userRepository.findById(idUser).get();
    }
}