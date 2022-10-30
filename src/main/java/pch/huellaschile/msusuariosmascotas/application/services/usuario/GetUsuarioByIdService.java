package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.GetUsuarioByIdUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

import java.util.Optional;

@Service
public class GetUsuarioByIdService implements GetUsuarioByIdUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Optional<Usuario> execute(Integer idUsuario){
        return gateway.getByIdUsuario(idUsuario);
    }

}
