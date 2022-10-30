package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.GetAllUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

import java.util.List;

@Service
public class GetAllUsuarioService implements GetAllUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public List<Usuario> execute(){
        return gateway.getAll();
    }
}
