package pch.huellaschile.msusuariosmascotas.infrastructure.crud;

import org.springframework.data.repository.CrudRepository;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.MascotaDAO;

import java.util.List;

public interface MascotaCrudRepository extends CrudRepository<MascotaDAO, Integer> {
    List<MascotaDAO> findByIdUsuarioAndTratamientoTrue(int idUsuario);

    MascotaDAO findByIdUsuarioAndIdMascota(int idUsuario, int idMascota);

    List<MascotaDAO> findByNombreOrRaza(String nombre, String raza);

    Boolean existsByIdMascotaAndTratamientoTrue(int idMascota);

    Boolean existsByNombreContainingIgnoreCase(String nombre);
}