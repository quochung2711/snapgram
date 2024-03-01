package vn.com.hungdinh.snapgram.snapgramapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class RoleModel {

    // Role id
    @Id
    @Column(name = "iduser_role")
    private int roleId;

    // role name
    @Column(name = "role_name")
    private String roleName;
}
