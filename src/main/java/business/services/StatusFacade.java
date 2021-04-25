package business.services;

import business.entities.Status;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.StatusMapper;

import java.util.List;

public class StatusFacade {
    private StatusMapper statusMapper;

    public StatusFacade(Database database) {
        this.statusMapper = new StatusMapper(database);
    }

    public List<Status> getAllStatus() throws UserException {
        return statusMapper.getAllStatus();
    }
}
