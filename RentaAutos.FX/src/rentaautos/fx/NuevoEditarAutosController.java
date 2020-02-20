/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import rentaautos.bl.Autos;
import rentaautos.bl.Categoria;
import rentaautos.bl.CategoriaServicio;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class NuevoEditarAutosController implements Initializable {
   
    
    @ FXML
    Button btnCancelar;
    
   @ FXML
    TextField txtId;
    
   @ FXML
    TextField txtMarcas;
   
     @ FXML
    TextField txtPrecio;
     
       @ FXML
    TextField txtAutosD;
       
         @ FXML
    ComboBox comboCategoria;
    
     private FormAutosController controller;
     private Autos auto;
     private CategoriaServicio categoriaServicio;
     
     
     public void setController(FormAutosController controller){
         this.controller = controller;
         
         
     }
     
     public void setAutos(Autos auto){
         this.auto = auto;
      
         txtId.textProperty().bindBidirectional(auto.idProperty(), new NumberStringConverter());
      txtMarcas.textProperty().bindBidirectional(auto.MarcasProperty());
      txtPrecio.textProperty().bindBidirectional(auto.PrecioxDiaProperty(),new NumberStringConverter() ); 
      txtAutosD.textProperty().bindBidirectional(auto.AutosDisponibleProperty(), new NumberStringConverter());
      comboCategoria.valueProperty().bindBidirectional(auto.categoriaProperty()); 
         
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           categoriaServicio = new CategoriaServicio();
           
           ObservableList<Categoria> data = FXCollections.observableArrayList(categoriaServicio.ObtenerCategoria());
           comboCategoria.setItems(data);
        
    }  
    public void aceptar(){
        String resultado = controller.guardar(auto);
        if(resultado.equals(""))
        {
        cerrar();
        }
        else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("autos");
                alert.setHeaderText("Error de Validacion de Datos");
                alert.setContentText(resultado);
                alert.showAndWait();
                }
    }
    
    public void cancelar(){
        
        cerrar();
    }
    
    private void cerrar()
    {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
