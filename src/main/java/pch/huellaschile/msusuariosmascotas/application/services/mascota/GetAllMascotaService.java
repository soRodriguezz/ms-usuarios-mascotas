package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.GetAllUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;

import java.util.List;

@Service
public class GetAllMascotaService implements GetAllUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public List<Mascota> execute() {
        return gateway.getAll();
    }

}
