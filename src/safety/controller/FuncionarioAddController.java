/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import safety.model.domain.Funcionario;

/**
 * FXML Controller class
 *
 * @author Jair
 */
public class FuncionarioAddController implements Initializable {

    @FXML
    private JFXTextField nomeTextField;
    @FXML
    private JFXComboBox<String> cargoComboBox;
    @FXML
    private JFXComboBox<String> estadoComboBox;
    
    private ObservableList<String> cargoObservableList;
    private ObservableList<String> estadoObservableList;    
    
    private Stage dialogStage;
    private Funcionario funcionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        funcionario = new Funcionario();
        carregarComboBox();
    }    
    
    public void carregarComboBox(){
        cargoObservableList = FXCollections.observableArrayList("Administrador", "Secretaria", "Agente");
        cargoComboBox.setItems(cargoObservableList);
        estadoObservableList = FXCollections.observableArrayList("Ativo", "Desativo");
        estadoComboBox.setItems(estadoObservableList);
    }
    
    public void confirmar(){
        funcionario.setNome(nomeTextField.getText());
        funcionario.setCargo(cargoComboBox.getSelectionModel().getSelectedItem());
        funcionario.setEstado(estadoFuncionario());
        
        funcionario.adicionarFuncionario(funcionario);
        dialogStage.close();
    }

    public boolean estadoFuncionario(){
        String estado = estadoComboBox.getSelectionModel().getSelectedItem();
        if(estado.equals("Ativo")){
            return true;
        }else if(estado.equals("Desativo")){
            return false;
        }
        return false;
    }
   
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    
    
}
