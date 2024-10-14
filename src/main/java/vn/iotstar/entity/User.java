package vn.iotstar.entity;

import java.io.Serializable;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId; // Thay đổi tên từ userId sang id

    @Column(name = "email", columnDefinition = "NVARCHAR(255) NOT NULL")
    @NotEmpty(message = "Email không được phép rỗng")
    private String email; // Email của người dùng

    @Column(name = "username", columnDefinition = "NVARCHAR(255) NOT NULL")
    @NotEmpty(message = "Username không được phép rỗng")
    private String username; // Tên người dùng

    @Column(name = "fullname", columnDefinition = "NVARCHAR(255) NOT NULL")
    private String fullname; // Họ và tên của người dùng

    @Column(name = "password", columnDefinition = "NVARCHAR(255) NOT NULL")
    @NotEmpty(message = "Password không được phép rỗng")
    private String password; // Mật khẩu

    @Column(name = "image", columnDefinition = "NVARCHAR(MAX) NULL")
    private String image; // Đường dẫn tới hình ảnh của người dùng

    @Column(name = "roleId")
    private int roleId; // ID vai trò của người dùng

    @Column(name = "phone", columnDefinition = "NVARCHAR(100)")
    private String phone; // Số điện thoại

	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    

	
}

