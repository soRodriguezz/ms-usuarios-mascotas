package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.SaveUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

@Service
public class SaveUsuarioService implements SaveUsuarioUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Usuario execute(Usuario usuario){

        Usuario usu = gateway.findByRut(usuario.getRut());

        if(usu != null){
            // TODO devolver excepcion
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ya existe");
        }

        return gateway.saveUsuario(usuario);

    }
}
