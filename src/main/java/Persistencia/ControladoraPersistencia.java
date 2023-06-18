package Persistencia;

import Logica.Alumno;
import Logica.Papa;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    PapaJpaController papaJpa = new PapaJpaController();
    AlumnoJpaController alumnoJpa = new AlumnoJpaController();

    public void guardar(Papa papa, Alumno alumno) {
    
        //Creamos en la BD al papa
        papaJpa.create(papa);
        
        //creamos en la BD al alumno
        alumnoJpa.create(alumno);
        
    }

    public List<Alumno> traerAlumnos() {
      
        return alumnoJpa.findAlumnoEntities();
        
    }

    public void borrarAlumno(int num_alumno) {
        try {
            alumnoJpa.destroy(num_alumno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int num_alumno) {
       
        return alumnoJpa.findAlumno(num_alumno);
        
    }

    public void modificarAlumno(Alumno alumno) {
        try {
            alumnoJpa.edit(alumno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Papa traerPapa(int num_Papa) {
       
        return papaJpa.findPapa(num_Papa);
        
    }

    public void modificarPapa(Papa papa) {
        
        try {
            papaJpa.edit(papa);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
