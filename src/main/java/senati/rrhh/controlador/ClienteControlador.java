package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senati.rrhh.modelo.Clientes;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IClienteServicio;
import senati.rrhh.servicio.IEmpleadoServicio;

import java.util.List;

@RestController
//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value = "http://localhost:3000")

public class ClienteControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private IClienteServicio clienteServicio;

    //http://localhost:8080/rrhh-app/clientes
    @GetMapping("/clientes")
    public List<Clientes> obtenerClientes(){
        var clientes = clienteServicio.ListarCliente();
        clientes.forEach(clientes1 -> logger.info(clientes.toString()));
        return clientes;
    }
}
