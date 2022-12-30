package pch.huellaschile.msusuariosmascotas.infrastructure.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String rut;

    private String nombre;

    private String apellido;

    @OneToMany(mappedBy = "usuario")
    private List<MascotaDAO> mascotaDAOList;

    public UsuarioDAO() {
    }

    public UsuarioDAO(Integer idUsuario, String rut, String nombre, String apellido, List<MascotaDAO> mascotaDAOList) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mascotaDAOList = mascotaDAOList;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<MascotaDAO> getMascotaDAOList() {
        return mascotaDAOList;
    }

    public void setMascotaDAOList(List<MascotaDAO> mascotaDAOList) {
        this.mascotaDAOList = mascotaDAOList;
    }
}
