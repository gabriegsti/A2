package Controller;

import Service.CadastroVendedorExternoService;
import Service.ListarVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaInicialController {

	CadastroVendedorExternoService CadastrotelaVendedorExterno = new CadastroVendedorExternoService();
	ListarVendedorExternoService ListartelaVendedorExterno = new ListarVendedorExternoService();
	TelaInicialService tela = new TelaInicialService();

	public void abrirTelaInicial() {
		tela.abrirTela();
	}

	@FXML
	public void abrirCadastrodeVendedorExternoAction(ActionEvent event) {
		CadastrotelaVendedorExterno.abrirTela();
		TelaInicialService.fecharTela();
	}

	@FXML
	public void abrirListardeVendedorExternoAction(ActionEvent event) {
		ListartelaVendedorExterno.abrirTela();
		TelaInicialService.fecharTela();
	}

}
