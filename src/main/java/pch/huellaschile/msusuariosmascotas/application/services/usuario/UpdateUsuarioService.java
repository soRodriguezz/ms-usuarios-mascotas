package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.UpdateUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

@Service
public class UpdateUsuarioService implements UpdateUsuarioUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Usuario execute(Usuario usuario){

        return gateway.updateUsuario(usuario);

    }

}
