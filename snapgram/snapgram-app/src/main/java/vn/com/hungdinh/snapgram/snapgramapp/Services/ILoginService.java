package vn.com.hungdinh.snapgram.snapgramapp.Services;

import java.util.Optional;

import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;

public interface ILoginService {
    
    Optional<UsersModel> findByUsername(String username);

    Optional<UsersModel> findByEmail(String email);

    void saveUser(UsersModel usersModel);
}
