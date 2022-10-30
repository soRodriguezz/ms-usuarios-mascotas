package pch.huellaschile.msusuariosmascotas.infrastructure.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.infrastructure.models.MascotaDAO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MascotaMapper {
    @Mappings({
            @Mapping(source = "idMascota", target = "idMascota"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "tratamiento", target = "tratamiento"),
            @Mapping(source = "raza", target = "raza"),
            @Mapping(source = "usuario", target = "usuario"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })
    Mascota toMascota(MascotaDAO mascotaDAO);

    List<Mascota> toMascotas(List<MascotaDAO> daos);

    @InheritInverseConfiguration
    MascotaDAO toMascotaDAO(Mascota mascota);
}
