/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.bl;

/**
 *
 * @author dell
 */
public class Categoria {
    
    private Integer Id; 
    private String marcas;

    public Categoria(String marcas) {
        this.marcas = marcas;
    }

    public Categoria() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }
       @Override
    public String toString() {
        return marcas;
    }
}
