package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.DeleteUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

import java.util.List;

@Service
public class DeleteUsuarioService implements DeleteUsuarioUseCase {
    @Autowired
    private UsuarioGateway gateway;

    @Autowired
    private MascotaGateway gatewayMascota;

    @Override
    public Boolean execute(Integer idUsuario){

        List<Mascota> mascotas = gatewayMascota.findByIdUsuarioAndTratamientoTrue(idUsuario);

        if(!mascotas.isEmpty()){
            // TODO devolver excepcion
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario tiene mascotas con tratamiento");
        }

        return gateway.getByIdUsuario(idUsuario).map(certification -> {
            gateway.deleteUsuarioById(idUsuario);
            return true;
        }).orElse(false);
    }
}
