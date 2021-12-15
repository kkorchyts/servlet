package com.kkorchyts.jwd.model.building;

import com.kkorchyts.jwd.model.Role;

public class RoleBuilder extends AbstractBuilder<Role>{
    private Integer id;
    private String role;
    private String description;

    public static RoleBuilder builder() {
        return new RoleBuilder();
    }

    public RoleBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public RoleBuilder role(String role) {
        this.role = role;
        return this;
    }

    public RoleBuilder description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Role build() {
        Role newRole = new Role();
        newRole.setId(id);
        newRole.setDescription(description);
        newRole.setRole(role);
        return newRole;
    }
}
