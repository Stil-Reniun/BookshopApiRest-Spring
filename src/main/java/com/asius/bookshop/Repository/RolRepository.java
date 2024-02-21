package com.asius.bookshop.Repository;
import com.asius.bookshop.Entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface    RolRepository extends JpaRepository<RolEntity,Integer> {
}
