package pch.huellaschile.msusuariosmascotas.application.services.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pch.huellaschile.msusuariosmascotas.application.ports.input.usuario.DeleteUsuarioUseCase;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;

@Service
public class DeleteUsuarioService implements DeleteUsuarioUseCase {
    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Boolean execute(Integer idUsuario){
        return gateway.getByIdUsuario(idUsuario).map(certification -> {
            gateway.deleteUsuarioById(idUsuario);
            return true;
        }).orElse(false);
    }
}
