
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import safety.model.domain.Cliente;


public class ClienteController implements Initializable {

    @FXML
    private TableView<Cliente> clinetesTableView;
    @FXML
    private TableColumn<Cliente, String> nomeTableColumn;
    @FXML
    private TableColumn<Cliente, String> sobrenomeTableColumn;
    @FXML
    private TableColumn<Cliente, Long> telefoneTableColumn;
    @FXML
    private TableColumn<Cliente, String> emailTableColumn;
    @FXML
    private TableColumn<Cliente, Integer> nifTableColumn;
    @FXML
    private TextField pesquisaTextFiled;

    
    private ObservableList<Cliente> verListaUtilizador;  
    private List<Cliente> listUtilizador;
    private Cliente cliente;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        cliente = new Cliente();
       
        prenxerTabela();
        
        pesquisaTextFiled.setOnKeyReleased((KeyEvent e) -> {
           pesquisarUtilizador();
        });
        
    }    
    
    public void prenxerTabela() {        
        nomeTableColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        sobrenomeTableColumn.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory("email"));
        telefoneTableColumn.setCellValueFactory(new PropertyValueFactory("telefone"));
        nifTableColumn.setCellValueFactory(new PropertyValueFactory("nif"));
        
        clinetesTableView.setItems(loadTable());
        
    }
    
    public ObservableList<Cliente> loadTable() {        
        return FXCollections.observableArrayList(cliente.listCliente());       
    }
     
    @FXML
    public void removerCliente(){
        Cliente clienteRemover = clinetesTableView.getSelectionModel().getSelectedItem();
        
        if(clienteRemover != null ){
            int selectedOption = JOptionPane.showConfirmDialog(null,"Tens certeza que queres remover?","Remover Cliente",JOptionPane.YES_NO_OPTION);
                if(selectedOption== JOptionPane.YES_OPTION){
                    cliente.eliminarCliente(clienteRemover);
                    prenxerTabela();                    
                }           
        }else {
           JOptionPane.showMessageDialog(null,"Selecionar Primeiro");
        }
    } 
     
    @FXML
    public void adicionarCliente() throws IOException{
        Cliente novoCliente = new Cliente();
        
        boolean botaoConfirmarClick = showCliente(novoCliente);
        
        if(botaoConfirmarClick){
            cliente.guardarCliente(novoCliente);
            prenxerTabela();
        }
    }
    
    @FXML
    public void editarCliente() throws IOException{
        Cliente clienteEditar = clinetesTableView.getSelectionModel().getSelectedItem();
        
        if(clienteEditar != null){
            boolean botaoConfirmarClick = showCliente(clienteEditar);
            if(botaoConfirmarClick){
                cliente.alterarCliente(clienteEditar);                
                prenxerTabela();
            }
        }else {
           JOptionPane.showMessageDialog(null,"Selecionar Primeiro");
        }        
    }
     
    public boolean showCliente(Cliente cliente) throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(AdicionarClienteController.class.getResource("/safety/view/AdicionarCliente.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cliente");
        dialogStage.setResizable(false);
        
        
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);
        
        AdicionarClienteController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);
        
        
        dialogStage.setAlwaysOnTop(true);
        dialogStage.showAndWait();
        return controller.isBotaoConfirmar();
    }
    
     
     public void pesquisarUtilizador(){
        verListaUtilizador =  FXCollections.observableArrayList();
        
        listUtilizador = cliente.listCliente();
        
        for(int i = 0; i < listUtilizador.size(); i++){
            if(listUtilizador.get(i).getNome().toLowerCase().contains(pesquisaTextFiled.getText().toLowerCase())){
                verListaUtilizador.add(listUtilizador.get(i));
                clinetesTableView.setItems(verListaUtilizador);
            }
        }
    }
     
     
     
     
     
     
   
}
