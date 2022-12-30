package pch.huellaschile.msusuariosmascotas.application.domain.entities;


public class Mascota {
    private int idMascota;
    private String nombre;
    private boolean tratamiento;
    private String raza;

    private int idUsuario;
    private Usuario usuario;

    public Mascota() {}

    public Mascota(int idMascota, String nombre, boolean tratamiento, String raza, int idUsuario, Usuario usuario) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.tratamiento = tratamiento;
        this.raza = raza;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(boolean tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + idMascota +
                ", nombre='" + nombre + '\'' +
                ", tratamiento=" + tratamiento +
                ", raza='" + raza + '\'' +
                ", idUsuario=" + idUsuario +
                ", usuario=" + usuario +
                '}';
    }
}
