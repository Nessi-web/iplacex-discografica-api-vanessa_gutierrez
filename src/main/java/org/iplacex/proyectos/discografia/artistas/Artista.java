package org.iplacex.proyectos.discografia.artistas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("artistas")
public class Artista {
    
    // id del artista
    @Id
    public String _id;
    
    // nombre del artista
    public String nombre;
    
    // estilos musicales del artista
    public List<String> estilos;
    
    // anio de fundacion del artista
    public int anioFundacion;
    
    // estado de actividad del artista
    public boolean estaActivo;
}