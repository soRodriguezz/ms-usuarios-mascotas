package pch.huellaschile.msusuariosmascotas.application.ports.input.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.commons.UseCase;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaDTO;

public interface SaveMascotaUseCase extends UseCase<RequestMascotaDTO, Mascota> {
}
