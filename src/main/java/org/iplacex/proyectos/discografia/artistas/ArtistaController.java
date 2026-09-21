package org.iplacex.proyectos.discografia.artistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtistaController {

    // repositorio de artista
    @Autowired
    private IArtistaRepository artistaRepo;

    // metodo para insertar artista
    @PostMapping(value = "/artista", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleInsertArtistaRequest(@RequestBody Artista artista) {
        Artista nuevoArtista = artistaRepo.insert(artista);
        return new ResponseEntity<>(nuevoArtista, HttpStatus.CREATED);
    }

    // metodo para obtener todos los artistas
    @GetMapping(value = "/artistas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artista>> HandleGetAristasRequest() {
        List<Artista> artistas = artistaRepo.findAll();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    // metodo para obtener artista por id
    @GetMapping(value = "/artista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleGetArtistaRequest(@PathVariable("id") String id) {
        Optional<Artista> tempArtista = artistaRepo.findById(id);
        if (!tempArtista.isPresent()) {
            // retorna not found si no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tempArtista.get(), HttpStatus.OK);
    }

    // metodo para actualizar artista por id
    @PutMapping(value = "/artista/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleUpdateArtistaRequest(@PathVariable("id") String id, @RequestBody Artista artista) {
        if (!artistaRepo.existsById(id)) {
            // retorna not found si no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        artista._id = id;
        Artista artistaActualizado = artistaRepo.save(artista);
        return new ResponseEntity<>(artistaActualizado, HttpStatus.OK);
    }

    // metodo para eliminar artista por id
    @DeleteMapping(value = "/artista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleDeleteArtistaRequest(@PathVariable("id") String id) {
        if (!artistaRepo.existsById(id)) {
            // retorna not found si no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        Artista artistaEliminado = artistaRepo.findById(id).get();
        artistaRepo.deleteById(id); 
        return new ResponseEntity<>(artistaEliminado, HttpStatus.OK);
    }
}