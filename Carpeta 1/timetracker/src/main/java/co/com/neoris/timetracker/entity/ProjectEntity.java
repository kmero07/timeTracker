package co.com.neoris.timetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Clase encaragada de definir el objeto que hace referencia a la tabla project de la base de datos
 */
@Entity
@Table(name= "project")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproject;

    @Column(name="project_name")
    private String projectName;
}
