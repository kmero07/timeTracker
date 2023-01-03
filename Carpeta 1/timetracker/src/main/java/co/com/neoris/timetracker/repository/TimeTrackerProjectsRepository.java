package co.com.neoris.timetracker.repository;

import co.com.neoris.timetracker.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz encaragada de definir la conexión con la base de datos y su respectiva tabla
 */
@Repository
public interface TimeTrackerProjectsRepository extends CrudRepository<ProjectEntity, Long> {
}
