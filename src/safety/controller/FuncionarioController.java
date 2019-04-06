/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import safety.model.domain.Funcionario;

/**
 * FXML Controller class
 *
 * @author Jair
 */
public class FuncionarioController implements Initializable {

    @FXML
    private TableView<Funcionario> funcionarioTable;
    @FXML
    private TableColumn<Funcionario, String> nomeColumn;
    @FXML
    private TableColumn<Funcionario, String> cargoColumn;
    @FXML
    private TableColumn<Funcionario, Boolean> estadoColumn;
    
    private ObservableList<Funcionario> observeListaFuncionario;  
    private List<Funcionario> listFuncionario;
    private Funcionario funcionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       funcionario = new Funcionario();
       prenxerTabela();
    }    
    public ObservableList<Funcionario> loadTable() {        
        return FXCollections.observableArrayList(funcionario.listFuncionario());       
    }
    
    public void prenxerTabela() {        
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        cargoColumn.setCellValueFactory(new PropertyValueFactory("cargo"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory("estado"));
        
        funcionarioTable.setItems(loadTable());
        
    }
    public void addFuncionario() throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(FuncionarioAddController.class.getResource("/safety/view/FuncionarioAdd.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Funcionario");
        dialogStage.setResizable(false);
        
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);
        
        FuncionarioAddController controller = loader.getController();
        controller.setDialogStage(dialogStage);        
        
        dialogStage.setAlwaysOnTop(true);
        dialogStage.showAndWait();
    }
    
    
    
}
