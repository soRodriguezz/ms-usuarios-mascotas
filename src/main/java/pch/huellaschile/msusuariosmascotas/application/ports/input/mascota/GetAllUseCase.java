package pch.huellaschile.msusuariosmascotas.application.ports.input.mascota;

import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllUseCase extends UseCaseWithOutInput<List<Mascota>>{
}
