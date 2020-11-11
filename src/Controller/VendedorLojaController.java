package Controller;

import Service.TelaInicialService;
import Service.VendedorLojaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VendedorLojaController {
	
	TelaInicialService tela = new TelaInicialService();
	
	@FXML
	private void VoltarParaTelaInicialAction(ActionEvent event) {
		tela.iniciar();
		VendedorLojaService.close();
	}
}
