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
public class CategoriaServicio {
    private final ArrayList<Categoria> catalagodeCategoria;

    public CategoriaServicio() {
        catalagodeCategoria =new ArrayList<>();
        
        crearDatosPrueba();
                
    }
    
    public ArrayList<Categoria>ObtenerCategoria(){
        return catalagodeCategoria;
    }

    private void crearDatosPrueba() {
       Categoria categoria1 = new Categoria("Automovil");
       categoria1.setId(1);
       
       Categoria categoria2 = new Categoria("Turismo");
       categoria2.setId(2);
       
       catalagodeCategoria.add(categoria1);
       catalagodeCategoria.add(categoria2);
    }
    
    
    
}
