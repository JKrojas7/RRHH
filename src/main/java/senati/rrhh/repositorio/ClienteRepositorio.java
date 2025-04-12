package senati.rrhh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.rrhh.modelo.Clientes;

public interface ClienteRepositorio extends JpaRepository<Clientes, Integer> {
}
