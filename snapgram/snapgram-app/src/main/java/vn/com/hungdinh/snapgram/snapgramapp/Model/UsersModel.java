package vn.com.hungdinh.snapgram.snapgramapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       }
)
public class UsersModel {

    // Identify of user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    // Username to login
    @Column(name = "username")
    @NonNull
    @Size(max = 20)
    private String username;

    // password of user
    @Column(name = "password")
    @NonNull
    private String password;

    // Email user
    @Column(name = "email")
    @NonNull
    @Email
    @Size(max = 50)
    private String email;

    // User Real Name
    @Column(name = "name")
    private String name;

    // Is active account
    @Column(name = "isactive")
    private boolean isActive;

    // Role of account
    @Column(name = "role_id")
    private int roleId;
 }
