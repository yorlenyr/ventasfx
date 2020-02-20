/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.bl;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class AutosServicio {
    
    private final ArrayList<Autos> catalagodeAutos;
     
    public AutosServicio(){
        catalagodeAutos = new ArrayList<>();
        crearDatosPrueba();
    }
     
    public ArrayList<Autos>ObtenerAutos(){
        return catalagodeAutos;
    }
    
     public ArrayList<Autos>ObtenerAutos(String buscar){
         if(buscar== null && buscar.equals(""))
         {
              return catalagodeAutos;
         }
         String buscarMinuscula = buscar.toLowerCase();
         ArrayList<Autos> resultado = new ArrayList<>();
         catalagodeAutos.forEach(auto ->{
             if(auto.getMarcas().toLowerCase().contains(buscar)==true){
                 resultado.add(auto);
             }
         });
        return resultado;
    }
    public String guardar(Autos auto){
        String resultado = validarAutos(auto);
       if( resultado.equals("")){
           
       
         if(auto.getId().equals(0)){
             Integer id = obtenerSguiente();
             auto.setId(id);
             
             catalagodeAutos.add(auto);
         }
    
         
         else{
             catalagodeAutos.forEach((Autos autoExistente) ->{
                 if(autoExistente.getId().equals(auto.getId())){
                    autoExistente.setMarcas(auto.getMarcas());
                    autoExistente.setMarcas(auto.getMarcas());
                    autoExistente.setCategoria(auto.getCategoria());
                    autoExistente.setPrecioxDia(auto.getPrecioxDia());
                    autoExistente.setAutosDisponibles(auto.getAutosDisponibles());
                 }
             });
         } 
         
         return "";    
       }else{
           return resultado;
       } 
    }
     public void eliminar(Autos auto){
         catalagodeAutos.remove(auto);
     }
    
    private void crearDatosPrueba() {
        
        
       Categoria categoria2  = new Categoria("Automovil");
       categoria2.setId(1);
      
       
       Autos auto1 = new Autos();
       auto1.setId(1);
       auto1.setMarcas("Toyota");
       auto1.setCategoria(categoria2);
       auto1.setPrecioxDia(500000.00);
       auto1.setAutosDisponibles(5);
       
       Autos auto2 = new Autos();
       auto2.setId(2);
       auto2.setMarcas("Ford");
       auto2.setCategoria(categoria2);
       auto2.setPrecioxDia(600000.00);
       auto2.setAutosDisponibles(5);
       
       catalagodeAutos.add(auto1);
       catalagodeAutos.add(auto2);
    }

    private Integer obtenerSguiente() {
       Integer maxId = 1;
       for(Autos auto: catalagodeAutos){
           if(auto.getId() >= maxId){
               maxId = auto.getId()+1;
           }
       }
    

           return maxId;
    
    }

    private String validarAutos(Autos auto) {
      
         if(auto.getMarcas()== null || auto.getMarcas().equals(""))
        {
            return "Ingrese la Marca";
        }
        
        
        if(auto.getCategoria() == null)
        {
            return "seleccione una categoria";
        }
        
        if(auto.getPrecioxDia() < 0){
            return "Ingrese un precio mayor o igual a cero";
        }
         if(auto.getAutosDisponibles()< 0){
            return "Los Autos Disponibles deben ser mayor a cero";
         }
         
         
         return "";
    }
}
