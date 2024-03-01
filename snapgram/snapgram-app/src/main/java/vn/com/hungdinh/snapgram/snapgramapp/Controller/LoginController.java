package vn.com.hungdinh.snapgram.snapgramapp.Controller;

import org.springframework.web.bind.annotation.RestController;

import vn.com.hungdinh.snapgram.snapgramapp.Common.Commons;
import vn.com.hungdinh.snapgram.snapgramapp.Data.Repository.UsersRepository;
import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;
import vn.com.hungdinh.snapgram.snapgramapp.Model.RequestModel.LoginRequestModel;
import vn.com.hungdinh.snapgram.snapgramapp.Model.ResponseModel.LoginResponseModel;
import vn.com.hungdinh.snapgram.snapgramapp.Model.ResponseModel.TestClass;
import vn.com.hungdinh.snapgram.snapgramapp.Services.ServiceImplement.LoginServiceImplement;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class LoginController {

    @Autowired
    LoginServiceImplement loginServiceImplement;

    @Autowired
    UsersRepository usersRepository;
    
    /**
     * Method sign up account
     * 
     * @param loginRequestModel
     * @return
     */
    @PostMapping("/sign-up")
    public ResponseEntity<LoginResponseModel> signUp(@RequestBody UsersModel usersModel) {
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        try {
            // Check username and email not exist
            if (loginServiceImplement.checkUserInfo(usersModel)) {
                loginServiceImplement.saveUser(usersModel);
                // Set message response and status code
                loginResponseModel.setMessageResponse("Sign up successlly");
                loginResponseModel.setResponeStatus(0);
            } else {
                loginResponseModel.setMessageResponse("Username or email is exist");
                loginResponseModel.setResponeStatus(0);
            }
        } catch (Exception e) {
            loginResponseModel.setMessageResponse(e.getMessage());
            loginResponseModel.setResponeStatus(1);
        }
        return new ResponseEntity<>(loginResponseModel, HttpStatus.OK);
    }

    /**
     * Login to web
     * 
     * @param loginRequestModel
     * @return
     */
    @GetMapping("/sign-in")
    public ResponseEntity<LoginResponseModel> login(@RequestBody LoginRequestModel loginRequestModel) {
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        try {
            Optional<UsersModel> loginInfo = loginServiceImplement.findByUsername(loginRequestModel.getUserName());
            if (Commons.checkEncodeString(loginRequestModel.getPassword(), loginInfo.get().getPassword())){
                loginResponseModel.setResponeStatus(0);
                loginResponseModel.setUser(loginInfo);
            } else {
                loginResponseModel.setResponeStatus(1);
                loginResponseModel.setMessageResponse("Password not match");
            }
            
        } catch (Exception e) {
            loginResponseModel.setResponeStatus(1);
            loginResponseModel.setMessageResponse(e.getMessage());
        }
        return new ResponseEntity<>(loginResponseModel, HttpStatus.OK);
    }

    /**
     * 
     * @return
     */
    @GetMapping("/getuser")
    public ResponseEntity<TestClass> getUsers() {
        TestClass testClass = new TestClass();
        testClass.setListUsers(usersRepository.findAll());
        return new ResponseEntity<>(testClass, HttpStatus.OK);
    }
    
}
