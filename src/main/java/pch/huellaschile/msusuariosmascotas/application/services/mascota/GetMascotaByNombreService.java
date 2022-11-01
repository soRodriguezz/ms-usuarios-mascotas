package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.GetMascotaByNombreUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestNombreRazaDTO;

import java.util.List;

@Service
public class GetMascotaByNombreService implements GetMascotaByNombreUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public List<Mascota> execute(RequestNombreRazaDTO dto) {

        String nombre = dto.getNombre();
        String raza = dto.getRaza();

        return gateway.findByNombreOrRaza(nombre, raza);
    }

}
