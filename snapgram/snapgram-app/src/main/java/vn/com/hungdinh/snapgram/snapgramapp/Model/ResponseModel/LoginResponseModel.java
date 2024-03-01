package vn.com.hungdinh.snapgram.snapgramapp.Model.ResponseModel;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import vn.com.hungdinh.snapgram.snapgramapp.Common.Model.ResponesesModel;
import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;

@Getter
@Setter
public class LoginResponseModel extends ResponesesModel{
    
    Optional<UsersModel> User;
}
