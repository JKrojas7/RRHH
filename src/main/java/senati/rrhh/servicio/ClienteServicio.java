package senati.rrhh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.rrhh.modelo.Clientes;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.repositorio.ClienteRepositorio;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepositorio;


    @Override
    public List<Clientes> ListarCliente() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Clientes buscarCleintePorId(Integer idCliente) {
        Clientes cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public Clientes guardarCliente(Clientes clientes) {
        return clienteRepositorio.save(clientes);
    }

    @Override
    public void eliminarCliente(Clientes clientes) {
        clienteRepositorio.delete(clientes);

    }
}
