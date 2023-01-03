package co.com.neoris.timetracker.application;

import co.com.neoris.timetracker.dto.ResponseDto;
import co.com.neoris.timetracker.dto.UserDto;

/**
 * Interfaz encargada de definir los metodos de la clase application
 */
public interface IUserTimeInfoApplication {
    ResponseDto getAllProjects();

    ResponseDto createUser(UserDto user);

    ResponseDto deleteUser(int idUser);

    ResponseDto getAllUsers();

    ResponseDto statusUserUpdate(int idUser, boolean active);
}
