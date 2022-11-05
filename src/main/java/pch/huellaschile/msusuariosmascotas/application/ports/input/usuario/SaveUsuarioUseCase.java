package pch.huellaschile.msusuariosmascotas.application.ports.input.usuario;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.commons.UseCase;

public interface SaveUsuarioUseCase extends UseCase<Usuario, Usuario> {
    Usuario execute(Usuario usuario) throws Exception;
}
