package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    private ERole roleName;
    
    public Role(){

    }

    public Role(Long roleId, ERole roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId(){
        return roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public ERole getRoleName(){
        return roleName;
    }

    public void setRoleName(ERole roleName){
        this.roleName = roleName;
    }
}
