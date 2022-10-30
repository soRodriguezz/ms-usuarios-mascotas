package pch.huellaschile.msusuariosmascotas.application.ports.input.usuario;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.commons.UseCase;

import java.util.Optional;

public interface GetUsuarioByIdUseCase extends UseCase<Integer, Optional<Usuario>> {
}
