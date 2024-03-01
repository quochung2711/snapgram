package vn.com.hungdinh.snapgram.snapgramapp.Model.RequestModel;

import lombok.Getter;
import lombok.Setter;
import vn.com.hungdinh.snapgram.snapgramapp.Common.Model.RequestModel;

@Setter
@Getter
public class LoginRequestModel extends RequestModel{
    private String userName;

    private String password;
}
