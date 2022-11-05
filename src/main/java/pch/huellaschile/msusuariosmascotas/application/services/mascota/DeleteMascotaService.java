package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.DuplicatedPetException;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.TreatmentActivePetException;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.DeleteMascotaUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;

@Service
public class DeleteMascotaService implements DeleteMascotaUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public Boolean execute(Integer idMascota) throws TreatmentActivePetException {
        boolean exist = gateway.existsByIdMascotaAndTratamientoTrue(idMascota);

        if(exist) {
            Object[] args = {idMascota};
            throw new TreatmentActivePetException("pet.treatmentactive.message", args);
        }

        return gateway.getMascotaById(idMascota).map(certification -> {
            gateway.deleteMascotaById(idMascota);
            return true;
        }).orElse(false);
    }

}
