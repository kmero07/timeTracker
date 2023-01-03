package co.com.neoris.timetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Clase encaragada de definir el objeto que hace referencia a la tabla user de la base de datos
 */
@Entity
@Table(name= "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserEntity {
    @Id
    @Column(name="iduser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="active")
    private String active;
}
