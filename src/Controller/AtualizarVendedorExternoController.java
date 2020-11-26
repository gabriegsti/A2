package Controller;


import Service.AtualizarVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AtualizarVendedorExternoController {

    @FXML
	private TextField BuscarPorIdtxt;
	 
	@FXML
    private TextField nomeVendedorExternotxt;

    @FXML
    private TextField telefoneVendedorExternotxt;

    @FXML
    private TextField dataDeNascimentoVendedorExternotxt;

    @FXML
    private TextField nomeClienteExternotxt;

    @FXML
    private TextField telefoneClienteExternotxt;

    @FXML
    private TextField dataDeNascimentoClienteExternotxt;

    @FXML
    private TextField salarioVendedorExternotxt;

    @FXML
    private TextField comissaoVendedorExternotxt;

    @FXML
    private TextField ajudaDeCustoVendedorExternotxt;
   
    
    
    AtualizarVendedorExternoService atualizarVendedorExternoService = new AtualizarVendedorExternoService();
    TelaInicialService telaInicial = new TelaInicialService();
    @FXML
   	private void VoltarParaTelaInicialAction(ActionEvent event) {
   		telaInicial.abrirTela();
   		AtualizarVendedorExternoService.fecharTela();
   	}
    
    
    public void buscarPorIdAction() {
		int id = Integer.parseInt(BuscarPorIdtxt.getText().trim());
		String[] campos = new String[11];
		String registro ;
		registro = atualizarVendedorExternoService.buscarPorId(id);
		campos =registro.split(":");
		nomeVendedorExternotxt.setText(campos[1]);
		telefoneVendedorExternotxt.setText(campos[2]);
		dataDeNascimentoVendedorExternotxt.setText(campos[3]);
		salarioVendedorExternotxt.setText(campos[4]);
		comissaoVendedorExternotxt.setText(campos[5]);
		ajudaDeCustoVendedorExternotxt.setText(campos[6]);
		nomeClienteExternotxt.setText(campos[7]);
		telefoneClienteExternotxt.setText(campos[8]);
		dataDeNascimentoClienteExternotxt.setText(campos[9]);
	}
    
    public void cadastrarAction() {
    	int id = Integer.parseInt(BuscarPorIdtxt.getText().trim());
    	 atualizarVendedorExternoService.cadastrarVendedorExterno(id,
    			 												  nomeVendedorExternotxt.getText(),
    			 												  telefoneVendedorExternotxt.getText(),
    			 												  dataDeNascimentoVendedorExternotxt.getText(),
    			 												  salarioVendedorExternotxt.getText(),
    			 												  comissaoVendedorExternotxt.getText(),
    			 												  ajudaDeCustoVendedorExternotxt.getText(),
    			 												  nomeClienteExternotxt.getText(),
    			 												  telefoneClienteExternotxt.getText(),
    			 												  dataDeNascimentoClienteExternotxt.getText());
      
    }
    public void SalvarAction(){
    	 atualizarVendedorExternoService.Salvar();   	
    }
    
}
