package vn.com.hungdinh.snapgram.snapgramapp.Model.ResponseModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import vn.com.hungdinh.snapgram.snapgramapp.Common.Model.ResponesesModel;
import vn.com.hungdinh.snapgram.snapgramapp.Model.UsersModel;

@Setter
@Getter
public class TestClass extends ResponesesModel{
    private List<UsersModel> listUsers;
}
