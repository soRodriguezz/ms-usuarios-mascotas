package pch.huellaschile.msusuariosmascotas.application.ports.input.usuario;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllUseCase extends UseCaseWithOutInput<List<Usuario>> {
}
