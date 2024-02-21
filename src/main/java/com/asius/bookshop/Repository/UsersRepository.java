package com.asius.bookshop.Repository;
import com.asius.bookshop.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    public UsersEntity findByUsername (String username);
}
