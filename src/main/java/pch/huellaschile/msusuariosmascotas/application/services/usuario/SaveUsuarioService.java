package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.domain.exception.DuplicatedUserException;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.SaveUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

@Service
public class SaveUsuarioService implements SaveUsuarioUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Usuario execute(Usuario usuario) throws Exception{

        Usuario usu = gateway.findByRut(usuario.getRut());

        if(usu != null){
            Object[] args = {usuario.getRut()};
            throw new DuplicatedUserException("user.duplicate.message", args);
        }

        return gateway.saveUsuario(usuario);

    }
}
