package com.dinoferre.portfolio.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dinoferre.portfolio.DTO.ExperienciaDTO;
import com.dinoferre.portfolio.Entity.ExperienciaEntity;
import com.dinoferre.portfolio.Security.Controller.Mensaje;
import com.dinoferre.portfolio.Service.ExperienciaService;

@RestController
@RequestMapping("/explaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
	
	//Inyecto el servicio
    @Autowired
    ExperienciaService experienciaService;
    
    //Lista para traer todas las experiencias
    @GetMapping("/lista")
    public ResponseEntity<List<?>> list(){
        List<ExperienciaEntity> list = experienciaService.list();
        return new ResponseEntity<List<?>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaEntity> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaEntity experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    //Crear una experiencia
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDTO experienciaDTO){      
        if(StringUtils.isBlank(experienciaDTO.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByNombreE(experienciaDTO.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaEntity experienciaEntity = new ExperienciaEntity(experienciaDTO.getNombreE(), experienciaDTO.getDescripcionE());
        experienciaService.save(experienciaEntity);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    //Actualizar experiencia
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDTO experienciaDTO){
        ExperienciaEntity experienciaEntity = experienciaService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID no existe"));

        if(experienciaService.existsByNombreE(experienciaDTO.getNombreE()) && experienciaService.getByNombreE(experienciaDTO.getNombreE()).get().getId() != id)
            return ResponseEntity.badRequest().body(new Mensaje("Esa experiencia ya existe"));

        if(StringUtils.isBlank(experienciaDTO.getNombreE()))
            return ResponseEntity.badRequest().body(new Mensaje("El nombre es obligatorio"));
        
        experienciaEntity.setNombreE(experienciaDTO.getNombreE());
        experienciaEntity.setDescripcionE((experienciaDTO.getDescripcionE()));

        experienciaService.save(experienciaEntity);
        return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }


    
    //Borrar una experiencia
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

}
