package pch.huellaschile.msusuariosmascotas.infrastructure.crud;

import org.springframework.data.repository.CrudRepository;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioDAO, Integer> {

    UsuarioDAO findByRut(String rut);

    Boolean existsByIdUsuario(int idUsuario);

}
