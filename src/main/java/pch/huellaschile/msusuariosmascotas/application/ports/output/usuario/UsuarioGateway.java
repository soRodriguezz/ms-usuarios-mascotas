package pch.huellaschile.msusuariosmascotas.application.ports.output.usuario;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> getAll();

    Optional<Usuario> getByIdUsuario(int idUsuario);

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuarioById(int idUsuario);

}
