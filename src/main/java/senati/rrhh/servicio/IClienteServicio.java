package senati.rrhh.servicio;

import senati.rrhh.modelo.Clientes;
import senati.rrhh.modelo.Empleado;

import java.util.List;

public interface IClienteServicio {
    public List<Clientes> ListarCliente();
    public Clientes buscarCleintePorId(Integer idCliente);
    public Clientes guardarCliente(Clientes clientes);
    public void eliminarCliente(Clientes clientes);
}
