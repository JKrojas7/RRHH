package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IEmpleadoServicio;

import java.util.List;

@RestController
//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value = "http://localhost:3000")

public class EmpleadoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio empleadoServicio;

    //http://localhost:8080/rrhh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.ListarEmpleados();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        return empleados;
    }
}
