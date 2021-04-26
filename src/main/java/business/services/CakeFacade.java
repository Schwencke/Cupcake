package business.services;

import business.entities.Bottom;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.CakeMapper;
import business.persistence.Database;

import java.util.List;

public class CakeFacade {
    private CakeMapper cakeMapper;

    public CakeFacade(Database database) {
        this.cakeMapper = new CakeMapper(database);
    }

    public List<Bottom> getAllBottoms() throws UserException {
        return cakeMapper.getAllBottoms();
    }

    public List<Topping> getAllToppings() throws UserException {
        return cakeMapper.getAllToppings();
    }
}
