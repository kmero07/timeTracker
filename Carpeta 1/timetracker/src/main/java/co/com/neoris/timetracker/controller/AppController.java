package co.com.neoris.timetracker.controller;

import co.com.neoris.timetracker.application.IUserTimeInfoApplication;
import co.com.neoris.timetracker.dto.ResponseDto;
import co.com.neoris.timetracker.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase encargada de la creación de los endpoints y el enrutamiento de estos a los métodos correspondientes
 */
@Slf4j
@RestController
@RequestMapping("/v1/timetracker")
public class AppController {
    @Autowired
    private IUserTimeInfoApplication application;

    /**
     * Método encargado de hacer el llamado para obtener todos los usuario creados en la base de datos
     * @return ResponseEntity: respuesta estandar con la información de los usuarios
     */
    @GetMapping("getAllUsers")
    public ResponseEntity<ResponseDto> getAllUsers(){
        ResponseDto response = application.getAllUsers();
        return new ResponseEntity<>(response, (response.getStatus().equals("OK"))?HttpStatus.OK:HttpStatus.CONFLICT);
    }

    /**
     * Método encargado de hacer el llamado para realizar la creación de usuario en la base de datos
     * @param user: información del usuario a crear
     * @return ResponseEntity: Respuesta exitosa o no de acuerdo a la finalización del proceso de creación del usuario
     */
    @PostMapping("createUser")
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto user){
        ResponseDto response = application.createUser(user);
        return new ResponseEntity<>(response, (response.getStatus().equals("OK"))?HttpStatus.OK:HttpStatus.CONFLICT);
    }

    /**
     * Método encargado de hacer el llamado para la eliminación de un usuario en la base de datos
     * @param userId: id único de usuario a eliminar
     * @return ResponseEntity: Respuesta exitosa o no de acuerdo a la finalización del proceso de eliminación del usuario
     */
    @DeleteMapping("deleteUser")
    public ResponseEntity<ResponseDto> deleteUser(@RequestParam int userId){
        ResponseDto response = application.deleteUser(userId);
        return new ResponseEntity<>(response, (response.getStatus().equals("OK"))?HttpStatus.OK:HttpStatus.CONFLICT);
    }

    /**
     * Método encargado de hacer el llamado para la modificación del atributo active de un usuario en base de datos
     * @param userId: id único del usuario a modificar
     * @param active: estado true o false a actualizar
     * @return
     */
    @PutMapping("modifyUserStatus")
    public ResponseEntity<ResponseDto> modifyStatusUser(@RequestParam int userId, @RequestParam boolean active){
        ResponseDto response = application.statusUserUpdate(userId, active);
        return new ResponseEntity<>(response, (response.getStatus().equals("OK"))?HttpStatus.OK:HttpStatus.CONFLICT);
    }
}
