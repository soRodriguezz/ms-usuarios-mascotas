package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.DeleteMascotaUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;

@Service
public class DeleteMascotaService implements DeleteMascotaUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public Boolean execute(Integer idMascota){
        return gateway.getMascotaById(idMascota).map(certification -> {
            gateway.deleteMascotaById(idMascota);
            return true;
        }).orElse(false);
    }

}
