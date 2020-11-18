package Controller;

import Service.TelaInicialService;
import Service.VendedorExternoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class TelaInicialController {

	VendedorExternoService telaVendedorExterno = new VendedorExternoService();
	TelaInicialService tela = new TelaInicialService();

	
	public void abrirTelaInicial() {
		tela.abrirTela();
	}
	
	
	@FXML
	private void abrirCadastrodeVendedorExternoAction(ActionEvent event) {
		telaVendedorExterno.abrirTela();
		TelaInicialService.fecharTela();
	}

}
