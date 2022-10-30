package pch.huellaschile.msusuariosmascotas.infrastructure.adapters.output;

import org.springframework.stereotype.Repository;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.ports.output.mascota.MascotaGateway;
import pch.huellaschile.msusuariosmascotas.infrastructure.crud.MascotaCrudRepository;
import pch.huellaschile.msusuariosmascotas.infrastructure.mappers.MascotaMapper;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.MascotaDAO;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaRepository implements MascotaGateway {

    private final MascotaCrudRepository repository;

    private final MascotaMapper mapper;

    public MascotaRepository(MascotaCrudRepository repository, MascotaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Mascota> getAll() {
        List<MascotaDAO> daos = (List<MascotaDAO>) repository.findAll();
        return mapper.toMascotas(daos);
    }

    @Override
    public Optional<Mascota> getMascotaById(int idMascota) {
        MascotaDAO mascotaDAO = repository.findById(idMascota).get();
        return Optional.ofNullable(mapper.toMascota(mascotaDAO));
    }

    @Override
    public Mascota saveMascota(Mascota mascota) {
        MascotaDAO mascotaDAO = repository.save(mapper.toMascotaDAO(mascota));
        return mapper.toMascota(mascotaDAO);
    }

    @Override
    public Mascota updateMascota(Mascota mascota) {
        MascotaDAO mascotaDAO = repository.save(mapper.toMascotaDAO(mascota));
        return mapper.toMascota(mascotaDAO);
    }

    @Override
    public void deleteMascotaById(int idMascota) {
        repository.deleteById(idMascota);
    }
}
