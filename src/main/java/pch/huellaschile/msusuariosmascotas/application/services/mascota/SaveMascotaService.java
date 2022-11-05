package pch.huellaschile.msusuariosmascotas.application.services.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.DuplicatedPetException;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.DuplicatedUserException;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.UserNotExistException;
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
    public Mascota execute(RequestMascotaDTO dto) throws DuplicatedPetException, UserNotExistException {

        boolean existeUsuario = gatewayUsuario.existsByIdUsuario(dto.getIdUsuario());
        Object[] args = {dto.getNombre()};

        if(!existeUsuario){
            throw new UserNotExistException("user.notexist.message", args);
        }

        boolean existMascota = gateway.existsByNombreContainingIgnoreCase(dto.getNombre());

        if(existMascota) {
            throw new DuplicatedPetException("pet.duplicated.message", args);
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
