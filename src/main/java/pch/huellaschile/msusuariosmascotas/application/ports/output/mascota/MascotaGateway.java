package pch.huellaschile.msusuariosmascotas.application.ports.output.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaGateway {

    List<Mascota> getAll();

    Optional<Mascota> getMascotaById(int idgetMascota);

    Mascota saveMascota(Mascota mascota);

    Mascota updateMascota(Mascota mascota);

    void deleteMascotaById(int idMascota);

}
