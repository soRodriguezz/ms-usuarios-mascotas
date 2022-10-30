package pch.huellaschile.msusuariosmascotas.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "rut", target = "rut"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido")
    })
    Usuario toUsuario(UsuarioDAO usuarioDAO);

    List<Usuario> toUsuarios(List<UsuarioDAO> daos);

    @InheritInverseConfiguration
    UsuarioDAO toUsuarioDAO(Usuario usuario);
}
