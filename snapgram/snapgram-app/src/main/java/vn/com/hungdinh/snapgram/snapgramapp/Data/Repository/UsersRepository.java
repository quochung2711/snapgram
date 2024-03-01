package vn.com.hungdinh.snapgram.snapgramapp.Data.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer>{
    
    Optional<UsersModel> findByEmail(String email);

    Optional<UsersModel> findByUsername(String username);
}
