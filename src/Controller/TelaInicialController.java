package Controller;

import Service.TelaInicialService;
import Service.VendedorLojaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TelaInicialController {

	VendedorLojaService vendedorLoja = new VendedorLojaService();
	@FXML
	private Label label;

	@FXML
	private void abrirCadastrodeVendedorLojaAction(ActionEvent event) {
		label.setText("dentro");
		vendedorLoja.CadastroVendedorLoja();
		TelaInicialService.close();
	}
	

}
