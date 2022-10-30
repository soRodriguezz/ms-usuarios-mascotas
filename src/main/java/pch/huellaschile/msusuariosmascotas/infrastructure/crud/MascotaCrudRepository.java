package pch.huellaschile.msusuariosmascotas.infrastructure.crud;

import org.springframework.data.repository.CrudRepository;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.MascotaDAO;

public interface MascotaCrudRepository extends CrudRepository<MascotaDAO, Integer> {
}