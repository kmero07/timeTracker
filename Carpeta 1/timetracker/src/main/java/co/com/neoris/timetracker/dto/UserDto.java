package co.com.neoris.timetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase encaragada de definir el objeto User que se requiere en la petición de entrada para la creación de este
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserDto {
    private String firstName;
    private String lastName;
}
