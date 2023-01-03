package co.com.neoris.timetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase encaragada de definir el objeto de respuesta del servicio
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ResponseDto {
    private String status;
    private String mensajeRespuesta;
    private Object response;
}
