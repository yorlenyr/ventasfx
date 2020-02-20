/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.bl;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dell
 */
public class Autos {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty marcas;
    private SimpleDoubleProperty precioxdia;
    private  SimpleIntegerProperty autosdisponibles;
    private SimpleObjectProperty categoria;
    private SimpleStringProperty Matricula;
    
    public Autos()
    {
        id= new SimpleIntegerProperty();
        marcas =new SimpleStringProperty();
        categoria = new SimpleObjectProperty();
        precioxdia= new SimpleDoubleProperty ();       
        autosdisponibles = new SimpleIntegerProperty();
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
    
    public SimpleIntegerProperty idProperty()
    {
        return id;
    }

    public String getMarcas() {
        return marcas.get();
    }

    public void setMarcas(String marcas) {
        this.marcas.setValue(marcas);

    }
    
    public SimpleStringProperty MarcasProperty(){
        return marcas;
    }
    
    
    public int getAutosDisponibles() {
        return autosdisponibles.get();
    }

    public void setAutosDisponibles(Integer autosdisponibles) {
        this.autosdisponibles.setValue(autosdisponibles);

    }
    
    public SimpleIntegerProperty AutosDisponibleProperty(){
        return autosdisponibles;
    }

    
    public Double getPrecioxDia() {
        return precioxdia.get();
    }
    public void setPrecioxDia(Double precioxdia) {
        this.precioxdia.set(precioxdia);
    }
    
     
    public SimpleDoubleProperty PrecioxDiaProperty(){
        return precioxdia;
    }
    
       
    public Categoria getCategoria() {
        return (Categoria) categoria.get();
    }
    public void setCategoria(Categoria categoria) {
        this.categoria.set(categoria);
    }
    
     
    public SimpleObjectProperty categoriaProperty(){
        return categoria;
    }
    
}
