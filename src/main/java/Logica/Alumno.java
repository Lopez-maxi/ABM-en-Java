package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_alumno;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha_nac;
    private String sexo;
    private String direccion;
    private String curso;
    private String turno;

    @OneToOne
    private Papa UnPapa;

    
    //constructor vacio
    public Alumno() {
    }

    //contructor con parametros

    public Alumno(int num_alumno, String nombre, String apellido, String dni, String fecha_nac, String sexo, String direccion, String curso, String turno, Papa UnPapa) {
        this.num_alumno = num_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.direccion = direccion;
        this.curso = curso;
        this.turno = turno;
        this.UnPapa = UnPapa;
    }

    public int getNum_alumno() {
        return num_alumno;
    }

    public void setNum_alumno(int num_alumno) {
        this.num_alumno = num_alumno;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Papa getUnPapa() {
        return UnPapa;
    }

    public void setUnPapa(Papa UnPapa) {
        this.UnPapa = UnPapa;
    }
    

   
    

   
    
    
    
    
}
