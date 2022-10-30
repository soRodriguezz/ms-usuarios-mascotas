package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.GetMascotaByIdUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;

import java.util.Optional;

@Service
public class GetMascotaByIdService implements GetMascotaByIdUseCase {
    @Autowired
    private MascotaGateway gateway;

    @Override
    public Optional<Mascota> execute(Integer idMascota){
        return gateway.getMascotaById(idMascota);
    }
}
