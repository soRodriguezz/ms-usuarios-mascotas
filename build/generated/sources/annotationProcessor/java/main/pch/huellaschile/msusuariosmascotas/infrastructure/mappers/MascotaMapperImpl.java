package pch.huellaschile.msusuariosmascotas.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.MascotaDAO;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T12:15:03-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.17 (Amazon.com Inc.)"
)
@Component
public class MascotaMapperImpl implements MascotaMapper {

    @Override
    public Mascota toMascota(MascotaDAO mascotaDAO) {
        if ( mascotaDAO == null ) {
            return null;
        }

        Mascota mascota = new Mascota();

        if ( mascotaDAO.getIdMascota() != null ) {
            mascota.setIdMascota( mascotaDAO.getIdMascota() );
        }
        mascota.setNombre( mascotaDAO.getNombre() );
        if ( mascotaDAO.getTratamiento() != null ) {
            mascota.setTratamiento( mascotaDAO.getTratamiento() );
        }
        mascota.setRaza( mascotaDAO.getRaza() );
        mascota.setUsuario( usuarioDAOToUsuario( mascotaDAO.getUsuario() ) );
        if ( mascotaDAO.getIdUsuario() != null ) {
            mascota.setIdUsuario( mascotaDAO.getIdUsuario() );
        }

        return mascota;
    }

    @Override
    public List<Mascota> toMascotas(List<MascotaDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Mascota> list = new ArrayList<Mascota>( daos.size() );
        for ( MascotaDAO mascotaDAO : daos ) {
            list.add( toMascota( mascotaDAO ) );
        }

        return list;
    }

    @Override
    public MascotaDAO toMascotaDAO(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }

        MascotaDAO mascotaDAO = new MascotaDAO();

        mascotaDAO.setIdMascota( mascota.getIdMascota() );
        mascotaDAO.setNombre( mascota.getNombre() );
        mascotaDAO.setTratamiento( mascota.isTratamiento() );
        mascotaDAO.setRaza( mascota.getRaza() );
        mascotaDAO.setUsuario( usuarioToUsuarioDAO( mascota.getUsuario() ) );
        mascotaDAO.setIdUsuario( mascota.getIdUsuario() );

        return mascotaDAO;
    }

    protected Usuario usuarioDAOToUsuario(UsuarioDAO usuarioDAO) {
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

    protected UsuarioDAO usuarioToUsuarioDAO(Usuario usuario) {
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
