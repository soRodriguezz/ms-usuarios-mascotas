package pch.huellaschile.msusuariosmascotas.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-29T22:41:55-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.17 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDAO usuarioDAO) {
        if ( usuarioDAO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( usuarioDAO.getIdUsuario() != null ) {
            usuario.setIdUsuario( usuarioDAO.getIdUsuario() );
        }
        usuario.setRut( usuarioDAO.getRut() );
        usuario.setNombre( usuarioDAO.getNombre() );
        usuario.setApellido( usuarioDAO.getApellido() );

        return usuario;
    }

    @Override
    public List<Usuario> toUsuarios(List<UsuarioDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( daos.size() );
        for ( UsuarioDAO usuarioDAO : daos ) {
            list.add( toUsuario( usuarioDAO ) );
        }

        return list;
    }

    @Override
    public UsuarioDAO toUsuarioDAO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.setIdUsuario( usuario.getIdUsuario() );
        usuarioDAO.setRut( usuario.getRut() );
        usuarioDAO.setNombre( usuario.getNombre() );
        usuarioDAO.setApellido( usuario.getApellido() );

        return usuarioDAO;
    }
}
