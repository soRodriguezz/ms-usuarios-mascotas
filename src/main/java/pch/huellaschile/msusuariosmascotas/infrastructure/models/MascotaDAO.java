package pch.huellaschile.msusuariosmascotas.infrastructure.models;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class MascotaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer idMascota;

    private String nombre;

    private Boolean tratamiento;

    private String raza;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false)
    private UsuarioDAO usuario;

    public MascotaDAO(Integer idMascota, String nombre, Boolean tratamiento, String raza, Integer idUsuario, UsuarioDAO usuario) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.tratamiento = tratamiento;
        this.raza = raza;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }

    public MascotaDAO() {
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Boolean tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDAO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDAO usuario) {
        this.usuario = usuario;
    }
}
