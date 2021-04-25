package business.services;

import business.entities.Role;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.RoleMapper;

import java.util.List;

public class RoleFacade {
    private RoleMapper roleMapper;

    public RoleFacade(Database database) {
        this.roleMapper = new RoleMapper(database);
    }

    public List<Role> getAllRoles() throws UserException {
        return roleMapper.getAllRoles();
    }
}
