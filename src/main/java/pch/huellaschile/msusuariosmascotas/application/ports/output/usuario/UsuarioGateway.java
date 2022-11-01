package pch.huellaschile.msusuariosmascotas.application.ports.output.usuario;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> getAll();

    Optional<Usuario> getByIdUsuario(int idUsuario);

    Usuario saveUsuario(Usuario usuario);

    Usuario findByRut(String rut);

    Usuario updateUsuario(Usuario usuario);

    boolean existsByIdUsuario(int idUsuario);

    void deleteUsuarioById(int idUsuario);

}
