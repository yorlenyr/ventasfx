/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentaautos.fx;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rentaautos.bl.Autos;
import rentaautos.bl.AutosServicio;


/**
 * FXML Controller class
 *
 * @author dell
 */
public class FormAutosController implements Initializable {
   @FXML
   private TableView tableView;
   
   @FXML
   private TableColumn<Autos, Integer> columnaId;
   
      @FXML
   private TableColumn<Autos, String> columnaMarcas;
      
      @FXML
   private TableColumn columnaEditar;
      
        
      @FXML
   private TableColumn columnaEliminar;
      
          @FXML
   private TableColumn <Autos, String > columnaCategoria;
      
          
       @FXML
   private TableColumn <Autos, Integer > columAutosD;

        @FXML
   private TableColumn <Autos, Double > columnPrecio;
       ObservableList<Autos> data;
       
     @FXML
   private TextField txtBuscar;
     
     
 
      
      AutosServicio servicio;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        servicio = new  AutosServicio();
        
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaMarcas.setCellValueFactory(new PropertyValueFactory("marcas"));
        columnaCategoria.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCategoria().getMarcas()));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("PrecioxDia"));
        columAutosD.setCellValueFactory(new PropertyValueFactory<>("AutosDisponibles"));
        
        definirColumEditar();
        definirColumnEliminar();
        
        cargarDatos();
       
    }    
     public void nuevoagregar() throws IOException{
         
         Autos NuevoAuto = new Autos();
         
      abrirVentanaModal(NuevoAuto, "Nuevo Auto");
     }
     
     public String guardar(Autos auto){
         String resultado =  servicio.guardar(auto);
         if(resultado.equals("")){
              cargarDatos();
         }
         return resultado;
     }
     
     public void buscar(){
      cargarDatos();
     }

    private void abrirVentanaModal(Autos auto,String titulo) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("NuevoEditarAutos.fxml"));
           Parent root = (Parent) loader.load();
           
           NuevoEditarAutosController controller = loader.getController();
           controller.setController(this);
           controller.setAutos(auto);
     
          Stage stage = new Stage();
          Scene scene = new Scene(root);
          stage.setScene(scene);
          
          stage.initModality(Modality.APPLICATION_MODAL);
          stage.setTitle(titulo);
          stage.show();
    }

    private void cargarDatos() {
        if(txtBuscar.getText()== null || txtBuscar.getText().equals("")){
            data = FXCollections.observableArrayList(servicio.ObtenerAutos()); 
        }else{
            data = FXCollections.observableArrayList(servicio.ObtenerAutos(txtBuscar.getText()));
        }
       
        
       tableView.setItems(data);
       tableView.refresh();
       
    }

    private void definirColumEditar() {
        columnaEditar.setCellFactory(param ->  new TableCell<String, String>(){
           final Button button = new Button("Editar");
           
           
           @Override
           public void updateItem(String item, boolean empty){
               super.updateItem(item, empty);
               if(empty)
               {
                   setGraphic(null);
                   setText(null);
               }
               else{
               button.setOnAction(event ->{
                   Autos auto = (Autos)getTableRow().getItem();
              
                 
                  
                   try {
                       abrirVentanaModal(auto, "Editar Autos");
                   } catch (IOException ex) {
                      Logger.getLogger(FormAutosController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 
                   
               });
               
               setGraphic(button);
               setText(null);
               
           }
           }
        });
    }

   

    private void definirColumnEliminar() {
        columnaEliminar.setCellFactory(param ->  new TableCell<String, String>(){
           final Button button = new Button("Elimitar");
           
           
           @Override
           public void updateItem(String item, boolean empty){
               super.updateItem(item, empty);
               if(empty)
               {
                   setGraphic(null);
                   setText(null);
               }
               else{
               button.setOnAction(event ->{
                   Autos auto = (Autos)getTableRow().getItem();
              
                 eliminar(auto);
                 
                   
               });
               
               setGraphic(button);
               setText(null);
               
           }
           }
        });
    }
     
    
    private void eliminar(Autos auto){
        Alert alert = new Alert (AlertType.CONFIRMATION, 
        "Seguro que desea eliminar este registro",
        ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult()== ButtonType.YES){
            servicio.eliminar(auto);
            cargarDatos();
        }
      
    }
    }

   

