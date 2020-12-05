package Controller;

import Service.ListarVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ListarVendedorExternoController {

	@FXML
	private Button btnBuscarPorId;

	@FXML
	private Button btnListarTodos;

	@FXML
	private TextField BuscarPorIdtxt;

	@FXML
	private TextArea listarTextArea;

	ListarVendedorExternoService listarVendedorExternoService = new ListarVendedorExternoService();
	TelaInicialService telaInicial = new TelaInicialService();
    @FXML
   	private void VoltarParaTelaInicialAction(ActionEvent event) {
   		telaInicial.abrirTela();
   		ListarVendedorExternoService.fecharTela();
   	}
	
	public void buscarPorIdAction() {
		int id = Integer.parseInt(BuscarPorIdtxt.getText().trim());
		listarTextArea.setText(listarVendedorExternoService.buscarPorId(id));
	}
	
	public void listarTodosAction() {
		listarTextArea.clear();
		listarTextArea.setText(listarVendedorExternoService.listarTodos());
	}
}
