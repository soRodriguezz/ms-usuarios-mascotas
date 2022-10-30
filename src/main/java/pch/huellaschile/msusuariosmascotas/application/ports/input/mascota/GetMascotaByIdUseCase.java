package pch.huellaschile.msusuariosmascotas.application.ports.input.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.commons.UseCase;

import java.util.Optional;

public interface GetMascotaByIdUseCase extends UseCase<Integer, Optional<Mascota>> {
}
