/**
 * La clase Seducacion es un componente de servicio de Spring que se utiliza para implementar la lógica de 
 * negocio relacionada con las entidades de educación y utiliza una única transacción de base de datos para 
 * todas las operaciones de base de datos realizadas dentro de los métodos de la clase. La clase define varios 
 * métodos para interactuar con las entidades de educación almacenadas en la base de datos y utiliza la 
 * instancia de REducacion inyectada mediante @Autowired.
 * 
 * @author Dino Ferré
 **/

package com.dinoferre.portfolio.Service;

import com.dinoferre.portfolio.Entity.Educacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinoferre.portfolio.Repository.REducacion;

import javax.transaction.Transactional;

@Service
@Transactional
public class Seducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNmbreE(String nombreE){
        return rEducacion.findByNombreE(nombreE);
    }
    
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rEducacion.existsByNombreE(nombreE);
    }
}