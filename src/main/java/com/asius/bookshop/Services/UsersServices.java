package com.asius.bookshop.Services;
import com.asius.bookshop.Entity.UsersRolEntity;
import com.asius.bookshop.Entity.UsersEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public interface UsersServices {

    public UsersEntity saveUserServices (UsersEntity usersEntity, Set<UsersRolEntity> usersRolEntity) throws Exception;

    public UsersEntity getUserService (String username);

    public void deleteUserService (Integer idUser);
    public List<UsersEntity> getAllUsers();
    UsersEntity getUserById(Integer idUser);
}
