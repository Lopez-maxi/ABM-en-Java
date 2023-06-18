package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Papa implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int num_Papa;
    private String Nombre_Papa;
    private String Cel_Papa;

    
    //constructor vacio
    public Papa() {
    }

    //constructor con parametros
    public Papa(int num_Papa, String NombrePapa, String CelPapa) {
        this.num_Papa = num_Papa;
        this.Nombre_Papa = NombrePapa;
        this.Cel_Papa = CelPapa;
    }

    public int getNum_Papa() {
        return num_Papa;
    }

    public void setNum_Papa(int num_Papa) {
        this.num_Papa = num_Papa;
    }

    public String getNombre_Papa() {
        return Nombre_Papa;
    }

    public void setNombre_Papa(String Nombre_Papa) {
        this.Nombre_Papa = Nombre_Papa;
    }

    public String getCel_Papa() {
        return Cel_Papa;
    }

    public void setCel_Papa(String Cel_Papa) {
        this.Cel_Papa = Cel_Papa;
    }

    
    
    
}
