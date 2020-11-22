package Controller;

import Service.ListarVendedorExternoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ListarVendedoresController {

	@FXML
	private Button btnBuscarPorId;

	@FXML
	private Button btnListarTodos;

	@FXML
	private TextField BuscarPorIdtxt;

	@FXML
	private TextArea listarTextArea;

	ListarVendedorExternoService listarVendedorExternoService = new ListarVendedorExternoService();

	public void buscarPorIdAction() {
		int id = Integer.parseInt(BuscarPorIdtxt.getText().trim());
		listarTextArea.setText(listarVendedorExternoService.buscarPorId(id));
	}
	
	public void listarTodosAction() {
		listarTextArea.clear();
		listarTextArea.setText(listarVendedorExternoService.listarTodos());
	}
}
