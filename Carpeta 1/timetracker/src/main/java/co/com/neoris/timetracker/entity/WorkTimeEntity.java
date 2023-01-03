package co.com.neoris.timetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

/**
 * Clase encaragada de definir el objeto que hace referencia a la tabla worktime de la base de datos
 */
@Entity
@Table(name= "worktime")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class WorkTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idworkTime;

    @Column(name="date")
    private Date date;

    @Column(name="hours")
    private Double hours;

    @Column(name="user")
    private int user;

    @Column(name="project")
    private int project;

}
