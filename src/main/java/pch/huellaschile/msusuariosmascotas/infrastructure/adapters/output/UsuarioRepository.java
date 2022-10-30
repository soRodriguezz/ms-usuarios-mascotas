package pch.huellaschile.msusuariosmascotas.infrastructure.adapters.output;

import org.springframework.stereotype.Repository;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.ports.output.usuario.UsuarioGateway;
import pch.huellaschile.msusuariosmascotas.infrastructure.crud.UsuarioCrudRepository;
import pch.huellaschile.msusuariosmascotas.infrastructure.mappers.UsuarioMapper;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.UsuarioDAO;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UsuarioGateway {

    private final UsuarioCrudRepository repository;

    private final UsuarioMapper mapper;

    public UsuarioRepository(UsuarioCrudRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> getAll() {
        List<UsuarioDAO> daos = (List<UsuarioDAO>) repository.findAll();
        return mapper.toUsuarios(daos);
    }

    @Override
    public Optional<Usuario> getByIdUsuario(int idUsuario) {
        UsuarioDAO usuarioDAO = repository.findById(idUsuario).get();
        return Optional.ofNullable(mapper.toUsuario(usuarioDAO));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = repository.save(mapper.toUsuarioDAO(usuario));
        return mapper.toUsuario(usuarioDAO);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = repository.save(mapper.toUsuarioDAO(usuario));
        return mapper.toUsuario(usuarioDAO);
    }

    @Override
    public void deleteUsuarioById(int idUsuario) {
        repository.deleteById(idUsuario);
    }
}
