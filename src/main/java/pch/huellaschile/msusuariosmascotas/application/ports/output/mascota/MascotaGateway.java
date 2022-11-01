package pch.huellaschile.msusuariosmascotas.application.ports.output.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaUsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface MascotaGateway {

    List<Mascota> getAll();

    Optional<Mascota> getMascotaById(int idgetMascota);

    Mascota saveMascota(Mascota mascota);

    List<Mascota> findByIdUsuarioAndTratamientoTrue(int idUsuario);

    List<Mascota> findByNombreOrRaza(String nombre, String raza);

    Mascota findByIdUsuarioAndIdMascota(int idUsuario, int idMascota);

    boolean existsByNombreContainingIgnoreCase(String nombre);

    boolean existsByIdMascotaAndTratamientoTrue(int idMascota);

    Mascota updateMascota(Mascota mascota);

    void deleteMascotaById(int idMascota);

}
