package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.input.mascota.SaveMascotaUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaDTO;

import java.util.Optional;

@Service
public class SaveMascotaService implements SaveMascotaUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Autowired
    private UsuarioGateway gatewayUsuario;

    @Override
    public Mascota execute(RequestMascotaDTO dto) {

        boolean existeUsuario = gatewayUsuario.existsByIdUsuario(dto.getIdUsuario());

        if(!existeUsuario){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe");
        }

        boolean existMascota = gateway.existsByNombreContainingIgnoreCase(dto.getNombre());

        if(existMascota) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre mascota ya existe");
        }

        Mascota mascota = new Mascota();

        int idUsuario = dto.getIdUsuario();

        Optional<Usuario> usuario = gatewayUsuario.getByIdUsuario(idUsuario);

        if(usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe");
        }

        mascota.setNombre(dto.getNombre());
        mascota.setTratamiento(dto.isTratamiento());
        mascota.setRaza(dto.getRaza());
        mascota.setIdUsuario(dto.getIdUsuario());
        usuario.ifPresent(mascota::setUsuario);

        return gateway.saveMascota(mascota);
    }


}
