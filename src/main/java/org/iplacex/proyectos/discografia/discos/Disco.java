package org.iplacex.proyectos.discografia.discos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

// mapea esta clase a la coleccion discos
@Document("discos")
public class Disco {
    
    // define esta propiedad como la clave primaria
    @Id
    public String _id;
    
    // relacion con el artista
    public String idArtista;
    
    // nombre del disco
    public String nombre;
    
    // anio de lanzamiento del disco
    public int anioLanzamiento;
    
    // lista de canciones del disco
    public List<String> canciones;
}