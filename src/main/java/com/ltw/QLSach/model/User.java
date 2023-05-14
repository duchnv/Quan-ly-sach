package com.ltw.QLSach.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;




@Entity
@Table(name = "users")
public class User {

    @Id
    @NotEmpty(message = "Thiếu thông tin")
    @Column(name = "username")
    private String username;
    
    
    @Min(value = 8, message = "Password phải từ 8 kí tự trở lên")
    @Column(name = "password")
    private String password;
    
    @Email(message = "Email không hợp lệ")
    private String email;
    
    @Pattern(regexp = "[a-zA-Z]+" ,message = "Tên chỉ chứa các chữ cái")
    @Column(name = "name")
    private String name;
    
    @NotEmpty(message = "Thiếu thông tin")
    @Column(name = "dob")
    private String dob;
    

    @Pattern(regexp = "[0-9]+" ,message = "Số điện thoại phải chứa các chữ số")
    @Column(name = "phone")
    private String phone;

  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
