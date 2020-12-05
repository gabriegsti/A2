package Controller;

import Service.DeletarVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeletarVendedorExternoController {

	@FXML
	private Button btnDeletarVendedor;

	@FXML
	private Button btnProcurarPorId;

	@FXML
	private TextArea listarTextArea;

	@FXML
	private TextField capIDtxt;

	DeletarVendedorExternoService deletarVendedorExternoService = new DeletarVendedorExternoService();
	TelaInicialService telaInicial = new TelaInicialService();
	
	public void buscarPorIdAction() {
		int id = Integer.parseInt(capIDtxt.getText().trim());
		listarTextArea.setText(deletarVendedorExternoService.buscarPorId(id));
	}

	public void deletarPorIdAction() {
		int id = Integer.parseInt(capIDtxt.getText().trim());
		deletarVendedorExternoService.deletaUmVendedor(id);
	}
	public void SalvarAction() {
		deletarVendedorExternoService.Salvar();
	}
	
	 @FXML
	private void VoltarParaTelaInicialAction(ActionEvent event) {
		telaInicial.abrirTela();
		DeletarVendedorExternoService.fecharTela();
	}
	
	

}
