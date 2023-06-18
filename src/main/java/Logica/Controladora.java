package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreAlumno, String apellido, String dni, String curso, 
            String direccion, String fechaNac, String sexo, String turno, String nombre_Papa, String cel_Papa) {
        
        //creamos al papa y le asignamos sus valores
        Papa papa = new Papa();
        
        papa.setNombre_Papa(nombre_Papa);
        papa.setCel_Papa(cel_Papa);
        
        
        //creamos al alumno y le asignamos sus valores
        Alumno alumno = new Alumno();
        
        alumno.setNombre(nombreAlumno);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setFecha_nac(fechaNac);
        alumno.setDireccion(direccion);
        alumno.setSexo(sexo);
        alumno.setCurso(curso);
        alumno.setTurno(turno);
        alumno.setUnPapa(papa);
        
        controlPersis.guardar(papa, alumno);
        
    }

    public List<Alumno> traerAlumnos() {
        
        return controlPersis.traerAlumnos();
        
    }

    public void borrarAlumno(int num_alumno) {
        
        controlPersis.borrarAlumno(num_alumno);
        
    }

    public Alumno traerAlumno(int num_alumno) {
      
        return controlPersis.traerAlumno(num_alumno);
        
    }

    public void modificarAlumno(Alumno alumno, String nombreAlumno, String apellido, String dni, 
            String curso, String direccion, String fechaNac, String sexo, String turno, 
            String nombre_Papa, String cel_Papa) {
      
        alumno.setNombre(nombreAlumno);
        alumno.setApellido(apellido);
        alumno.setDni(dni);
        alumno.setCurso(curso);
        alumno.setDireccion(direccion);
        alumno.setFecha_nac(fechaNac);
        alumno.setSexo(sexo);
        alumno.setTurno(turno);
        
        //modifico la mascota
        controlPersis.modificarAlumno(alumno);
        
        //seteo los nuevos valores del papa
        Papa papa = this.buscarPapa(alumno.getUnPapa().getNum_Papa());
        
        papa.setNombre_Papa(nombre_Papa);
        papa.setCel_Papa(cel_Papa);
        
        
        //llamo a modificar papa
        this.modificarPapa(papa);
    }

    private Papa buscarPapa(int num_Papa) {
        
        return controlPersis.traerPapa(num_Papa);
        
    }

    private void modificarPapa(Papa papa) {
        
        controlPersis.modificarPapa(papa);
        
    }

   
    
    
}
