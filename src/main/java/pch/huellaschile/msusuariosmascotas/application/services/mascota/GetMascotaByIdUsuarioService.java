package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.GetMascotaByIdUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaUsuarioDTO;

@Service
public class GetMascotaByIdUsuarioService implements GetMascotaByIdUsuarioUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public Mascota execute(RequestMascotaUsuarioDTO dto) {

        int idUsuario = dto.getIdUsuario();
        int idMascota = dto.getIdMascota();

        return gateway.findByIdUsuarioAndIdMascota(idUsuario, idMascota);
    }
}
