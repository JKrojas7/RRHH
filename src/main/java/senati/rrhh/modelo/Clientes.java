package senati.rrhh.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCliente;
    String apellido;
    String nombre;
    String telefono;
    String email;
    String direccion;
}
