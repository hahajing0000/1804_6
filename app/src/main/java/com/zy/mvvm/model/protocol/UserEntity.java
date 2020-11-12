package com.zy.mvvm.model.protocol;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public class UserEntity {
    private Long id;
    private String username;
    private int age;
    private String pwd;

    public UserEntity(Long id, String username, int age, String pwd) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.pwd = pwd;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
