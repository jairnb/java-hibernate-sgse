/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import safety.model.database.HibernateUtil;
import safety.model.domain.Cliente;

/**
 * FXML Controller class
 *
 * @author Christie
 */
public class AdicionarClienteController implements Initializable {
    
    @FXML
    private JFXTextField nomeTextField;
    @FXML
    private JFXTextField sobrenomeTextField;
    @FXML
    private JFXTextField telefoneTextField;
    @FXML
    private JFXTextField emailTextField;
    @FXML
    private JFXTextField nifTextField;

    private boolean botaoConfirmar = false;
    private Stage dialogStage;
    private Cliente cliente;
    //private Funcionario funcionario;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
       RequiredFieldValidator validator = new RequiredFieldValidator();
       NumberValidator numberValidator = new NumberValidator();
       
       nomeTextField.getValidators().add(validator);
       validator.setMessage("Os campos nao podem ser vazios");       
       nomeTextField.focusedProperty().addListener(new ChangeListener<Boolean>(){            
           @Override
           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               if(!newValue){
                   nomeTextField.validate();
               }
           }
       });
       
       sobrenomeTextField.getValidators().add(validator);
       validator.setMessage("Os campos nao podem ser vazios");       
       sobrenomeTextField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
           if(!newValue){
               sobrenomeTextField.validate();
           }
        });
       
       nifTextField.getValidators().add(numberValidator);
       numberValidator.setMessage("NIF é um campo nunmerico");
       nifTextField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
           if(!newValue){
               nifTextField.validate();
           }
       });
        //funcionario = new Funcionario();
        //funcionario = LoginController.userAtucalLogado;
    }   
    
    @FXML
    public void ConfirmarButton(){
        
       // cliente.setFuncionario(utilizador);
       cliente.setNome(nomeTextField.getText());
       cliente.setSobrenome(sobrenomeTextField.getText());
       cliente.setEmail(emailTextField.getText());
       cliente.setNif(Integer.parseInt(nifTextField.getText()));
       cliente.setTelefone(Integer.parseInt(telefoneTextField.getText()));
            
        botaoConfirmar = true;            
        dialogStage.close();
       
    }
    
    @FXML
    public void cancelarButton(){
        dialogStage.close();
    }
    
   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.nomeTextField.setText(cliente.getNome());
        this.sobrenomeTextField.setText(cliente.getSobrenome());
        this.emailTextField.setText(cliente.getEmail());
        this.telefoneTextField.setText(Integer.toString(cliente.getTelefone()));
        this.nifTextField.setText(Integer.toString(cliente.getNif()));
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
     
    
    public boolean isBotaoConfirmar() {
        return botaoConfirmar;
    }

    public void setBotaoConfirmar(boolean botaoConfirmar) {
        this.botaoConfirmar = botaoConfirmar;
    }
}
