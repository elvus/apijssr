package com.jsr.api.model;

import javax.persistence.*;

@Entity()
@Table(name = "users")

public class User {
    @Id
    private Integer id_usuario;
    @Column
    private String alias_usuario;
    @Column
    private String pass_usuario;
    @Transient
    private String token;

    public User(){
    }

    public User(String alias_usuario, String pass_usuario){
        this.alias_usuario=alias_usuario;
        this.pass_usuario=pass_usuario;
    }

    public void setId_usuario(int id_usuario){
        this.id_usuario=id_usuario;
    }
    public int getId_usuario(){
        return id_usuario;
    }

    public void setAlias_usuario(String alias_usuario){
        this.alias_usuario=alias_usuario;
    }
    public String getAlias_usuario(){
        return alias_usuario;
    }

    public void setPass_usuario(String pass_usuario){
        this.pass_usuario=pass_usuario;
    }
    public String getPass_usuario(){
        return pass_usuario;
    }

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.token = token;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return '{'+alias_usuario+','+pass_usuario+'}';
    }
}
