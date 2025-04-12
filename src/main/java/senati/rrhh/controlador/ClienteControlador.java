package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Clientes;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IClienteServicio;
import senati.rrhh.servicio.IEmpleadoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("/clientes")
    public Clientes agregarCliente(@RequestBody Clientes clientes){
        return clienteServicio.guardarCliente(clientes);
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Clientes> buscarClienteporId(@PathVariable Integer id){
        Clientes clientes = clienteServicio.buscarCleintePorId(id);
        return ResponseEntity.ok(clientes);
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Clientes> actualizarCliente(@PathVariable Integer id ,
                                                       @RequestBody Clientes clienteUpdate){
        Clientes clientes =clienteServicio.buscarCleintePorId(id);
        clientes.setApellido(clienteUpdate.getApellido());
        clientes.setNombre(clienteUpdate.getNombre());
        clientes.setEmail(clienteUpdate.getEmail());
        clientes.setTelefono(clienteUpdate.getTelefono());
        clientes.setNombre(clienteUpdate.getNombre());

        clienteServicio.guardarCliente(clientes);
        return ResponseEntity.ok(clientes);
    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Integer id){
        Clientes clientes = clienteServicio.buscarCleintePorId(id);
        clienteServicio.eliminarCliente(clientes);
        //imprimir mensaje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Cliente eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
