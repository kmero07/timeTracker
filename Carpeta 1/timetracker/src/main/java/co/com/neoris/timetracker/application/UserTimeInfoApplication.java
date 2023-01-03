package co.com.neoris.timetracker.application;

import co.com.neoris.timetracker.dto.ResponseDto;
import co.com.neoris.timetracker.dto.UserDto;
import co.com.neoris.timetracker.entity.UserEntity;
import co.com.neoris.timetracker.service.ITimeTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase encargada de realizar la lógica del negocio
 */
@Service
public class UserTimeInfoApplication implements IUserTimeInfoApplication{

    @Autowired
    ITimeTrackerService service;

    /**
     * Método encargado de devolver todos los proyectos almacenados en la tabla projects
     * @return ResponseDto: Objeto respuesta con los atributos requeridos por el negocio
     */
    @Override
    public ResponseDto getAllProjects() {
        ResponseDto response = new ResponseDto();
        response.setResponse(service.getAllProjects());
        response.setMensajeRespuesta("Se obtuvo esta respuesta por parte de la db");
        return response;
    }

    /**
     * Método encargado de realizar el llamado para la creación de un objeto usuario en la base de datos
     * @param user: objeto usuario definido por el cliente a la hora de consumir el servicio
     * @return ResponseDto: Objeto respuesta con los atributos requeridos por el negocio
     */
    @Override
    public ResponseDto createUser(UserDto user) {
        ResponseDto response = new ResponseDto();
        UserEntity userEntity = new UserEntity();
        try{
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setActive("false");
            UserEntity responseDb = service.createUser(userEntity);
            response.setMensajeRespuesta("Usuario creado");
            response.setResponse(responseDb);
            response.setStatus("OK");
        }catch(Exception e){
            response.setMensajeRespuesta("Error al crear usuario: "+e.getMessage());
            response.setStatus("ERROR");
        }
        return response;
    }

    /**
     * Método encargado de hacer el llamado para la eliminación de un usuario en la base de datos
     * @param idUser: id único del usuario a eliminar
     * @return ResponseDto: Objeto respuesta con los atributos requeridos por el negocio
     */
    @Override
    public ResponseDto deleteUser(int idUser) {
        ResponseDto response = new ResponseDto();
        try{
            Long user = Long.valueOf(idUser);
            service.deleteUser(user);
            response.setMensajeRespuesta("Se eliminó el usuario con id: "+idUser);
            response.setStatus("OK");
            response.setResponse("idUser eliminado: "+idUser);
        }catch (Exception e){
            response.setMensajeRespuesta("Error al eliminar usuario: "+e.getMessage());
            response.setStatus("ERROR");
        }
        return response;
    }

    /**
     * Método encargado de hacer el llamado para obtener todos los usuarios creados en base de datos
     * @return ResponseDto: Objeto respuesta con los atributos requeridos por el negocio
     */
    @Override
    public ResponseDto getAllUsers() {
        ResponseDto response = new ResponseDto();
        try{
            response.setResponse(service.getAllUsers());
            response.setMensajeRespuesta("Se obtuvo la siguiente lista de usuarios");
            response.setStatus("OK");
        }catch (Exception e){
            response.setMensajeRespuesta("Error al obtener usuarios: "+e.getMessage());
            response.setStatus("ERROR");
        }
        return response;
    }

    /**
     * Método encargado de hacer el llamado para actualizar el atributo active de los usuario en la db
     * @param idUser: id único del usuario a actualizar
     * @param active: estado que se le va a actualizar al usuario en el campo active
     * @return
     */
    @Override
    public ResponseDto statusUserUpdate(int idUser, boolean active) {
        ResponseDto response = new ResponseDto();
        try{
            UserEntity fullUser= service.getUserById(Long.valueOf(idUser));
            fullUser.setActive(active+"");
            service.activeUser(fullUser);
            response.setMensajeRespuesta("Se actualizó el usuario "+fullUser.toString());
            response.setStatus("OK");
        }catch (Exception e){
            response.setMensajeRespuesta("Error al actualizar usuario: "+e.getMessage());
            response.setStatus("ERROR");
        }
        return response;
    }
}
