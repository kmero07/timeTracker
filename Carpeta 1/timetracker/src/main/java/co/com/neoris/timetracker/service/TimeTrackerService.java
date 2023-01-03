package co.com.neoris.timetracker.service;

import co.com.neoris.timetracker.entity.ProjectEntity;
import co.com.neoris.timetracker.entity.UserEntity;
import co.com.neoris.timetracker.entity.WorkTimeEntity;
import co.com.neoris.timetracker.repository.TimeTrackerProjectsRepository;
import co.com.neoris.timetracker.repository.TimeTrackerUsersRepository;
import co.com.neoris.timetracker.repository.TimeTrackerWorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encaragada de realizar el llamado al repository para la respectiva conexión con la base de datos y su iteracción
 */
@Service
public class TimeTrackerService implements ITimeTrackerService{

    @Autowired
    TimeTrackerProjectsRepository repositoryProjects;

    @Autowired
    TimeTrackerUsersRepository repositoryUsers;

    @Autowired
    TimeTrackerWorkTimeRepository repositoryTime;

    /**
     * Método encargado de obtener los proyectos creados en la tabla projects
     * @return List<ProjectEntity>: lista de projectos en base de datos
     */
    @Override
    public List<ProjectEntity> getAllProjects() {
        List<ProjectEntity> projects = new ArrayList<>();
        repositoryProjects.findAll().forEach(project -> projects.add(project));
        return projects;
    }

    /**
     * Método encargado de realizar la iserción del objeto WorkTime en su respectiva tabla
     * @param workDay: día de ejecución de las horas de trabajo
     * @param time: horas trabajadas en su respectivo workday
     * @param idUser: id único de usuario quien ejecutó las horas
     * @param idProject: id único del proyecto en donde se hicieron efectivas las horas
     * @return WorkTimeEntity: objeto almacenado en la tabla
     */
    @Override
    public WorkTimeEntity insertTimeWork(Date workDay, Double time, int idUser, int idProject) {
        WorkTimeEntity data = new WorkTimeEntity(null, workDay, time, idUser, idProject);
        return repositoryTime.save(data);
    }

    /**
     * Método encargado de obtener todas las horas de trabajo ingresadas en la tabla worktime
     * @return List<WorkTimeEntity>: lista de objetos de horas trabajadas
     */
    @Override
    public List<WorkTimeEntity> getAllTimeWork() {
        List<WorkTimeEntity> response = new ArrayList<>();
        repositoryTime.findAll().forEach(element -> response.add(element));
        return response;
    }

    /**
     * Método encargado de eliminar objetos de tipo WorkTime almacenado en la base de datos
     * @param idWorkTime: id único de objeto WorkTime
     */
    @Override
    public void deleteTimeWork(Long idWorkTime) {
       repositoryTime.deleteById(idWorkTime);
    }

    /**
     * Método encargado de obtener un usuario por id
     * @param user: id único de usuario a consultar
     * @return UserEntity: objeto de usuario almacenado en base de datos
     */
    @Override
    public UserEntity getUserById(Long user) {
        UserEntity response = new UserEntity();
        return (UserEntity) repositoryUsers.findById(user).get();
    }

    /**
     * Método encargado de realizar la creación del usuario en la base de datos
     * @param user: objeto usuario a insertar en base de datos
     * @return
     */
    @Override
    public UserEntity createUser(UserEntity user) {
        return repositoryUsers.save(user);
    }

    /**
     * Método encargado de realizar la consulta de todos los usuario creados en base de datos
     * @return List<UserEntity>: lista de usuarios creados en base de datos
     */
    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        repositoryUsers.findAll().forEach(user -> users.add(user));
        return users;
    }

    /**
     * Método encargado de la eliminación de un usuario por id
     * @param idUser: identificador único de usuario a eliminar
     */
    @Override
    public void deleteUser(Long idUser) {
        repositoryUsers.deleteById(idUser);
    }

    /**
     * Método encargado de la modificación del actualización de un usuario
     * @param user: objeto usuario a actualizar
     */
    @Override
    public void activeUser(UserEntity user) {
        repositoryUsers.save(user);
    }


}
