package co.com.neoris.timetracker.service;

import co.com.neoris.timetracker.entity.ProjectEntity;
import co.com.neoris.timetracker.entity.UserEntity;
import co.com.neoris.timetracker.entity.WorkTimeEntity;

import java.sql.Date;
import java.util.List;

/**
 * Interfáz encaragada de definir los métodos impelmentados en la clase Service
 */
public interface ITimeTrackerService {

    List<ProjectEntity> getAllProjects();

    WorkTimeEntity insertTimeWork(Date workDay, Double time, int idUser, int idProject);

    List<WorkTimeEntity> getAllTimeWork();

    void deleteTimeWork(Long idWorkTime);

    UserEntity getUserById(Long user);

    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();

    void deleteUser(Long idUser);

    void activeUser(UserEntity user);
}
