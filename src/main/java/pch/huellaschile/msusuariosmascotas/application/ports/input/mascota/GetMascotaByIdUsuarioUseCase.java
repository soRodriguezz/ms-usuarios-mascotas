package pch.huellaschile.msusuariosmascotas.application.ports.input.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.commons.UseCase;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaUsuarioDTO;

public interface GetMascotaByIdUsuarioUseCase extends UseCase<RequestMascotaUsuarioDTO, Mascota> {
}
