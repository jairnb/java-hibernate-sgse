/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jair
 */
public class PaginaInicialAdminController implements Initializable {

    @FXML
    private AnchorPane PaginaIniciaAnchorPane;
    @FXML
    private AnchorPane topBarAnchorPane;
    @FXML
    private AnchorPane menuAnchorPane;
    @FXML
    private AnchorPane conteudosAnchorPane;
    
   private Button btn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/ConteudosInicialAdmin.fxml"));
            conteudosAnchorPane.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(PaginaInicialAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void paginaInicialAdminClicked() throws IOException  {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/ConteudosInicialAdmin.fxml"));
        conteudosAnchorPane.getChildren().setAll(a);        
    }
    
    public void funcionarioClicked() throws IOException  {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Funcionario.fxml"));
        conteudosAnchorPane.getChildren().setAll(a);
    }
    
    public void clienteoClicked() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Cliente.fxml"));
        conteudosAnchorPane.getChildren().setAll(a);
    }
    public void servicoClicked() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Servico.fxml"));
        conteudosAnchorPane.getChildren().setAll(a);
    }
    public void utilizadorClicked() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/utilizador.fxml"));
        conteudosAnchorPane.getChildren().setAll(a);
    }
    
    public void sairClicked() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Login.fxml"));
        PaginaIniciaAnchorPane.getChildren().setAll(a);
    }
    
}
