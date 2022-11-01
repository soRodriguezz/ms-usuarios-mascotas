package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.DeleteMascotaUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;

@Service
public class DeleteMascotaService implements DeleteMascotaUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public Boolean execute(Integer idMascota){
        boolean exist = gateway.existsByIdMascotaAndTratamientoTrue(idMascota);

        if(exist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tiene tratamiento activo");
        }

        return gateway.getMascotaById(idMascota).map(certification -> {
            gateway.deleteMascotaById(idMascota);
            return true;
        }).orElse(false);
    }

}
