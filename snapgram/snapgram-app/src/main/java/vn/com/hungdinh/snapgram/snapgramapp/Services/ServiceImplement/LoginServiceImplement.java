package vn.com.hungdinh.snapgram.snapgramapp.Services.ServiceImplement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vn.com.hungdinh.snapgram.snapgramapp.Data.Repository.UsersRepository;
import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;
import vn.com.hungdinh.snapgram.snapgramapp.Services.ILoginService;

@Transactional
@Service
public class LoginServiceImplement implements ILoginService{

    @Autowired
    UsersRepository usersRepository;

    /**
     * 
     */
    @Override
    public Optional<UsersModel> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    /**
     * @param email
     */
    @Override
    public Optional<UsersModel> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    /**
     * 
     * @param usersModel
     */
    @Override
    @Transactional
    public void saveUser(UsersModel usersModel) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode(usersModel.getPassword()); 
        if (usersModel != null){
            usersModel.setPassword(passwordEncode);
            usersRepository.save(usersModel);
        }
    }

    /**
     * 
     * @param usersModel
     * @return
     */
    public boolean checkUserInfo(UsersModel usersModel){
        if (findByEmail(usersModel.getEmail()).isPresent() ||
            findByUsername(usersModel.getUsername()).isPresent()) {
                return false;
        }
        return true;
    }
}
