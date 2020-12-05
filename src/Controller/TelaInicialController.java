package Controller;

import Service.AtualizarVendedorExternoService;
import Service.CadastroVendedorExternoService;
import Service.DeletarVendedorExternoService;
import Service.ListarVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaInicialController {


	CadastroVendedorExternoService cadastroTelaVendedorExternoService = new CadastroVendedorExternoService();
	ListarVendedorExternoService listarTelaVendedorExternoService = new ListarVendedorExternoService();
	AtualizarVendedorExternoService atualizarTelaVendedorExternoService = new AtualizarVendedorExternoService();
	DeletarVendedorExternoService deletarTelaVendedorExterno = new DeletarVendedorExternoService();
	TelaInicialService tela = new TelaInicialService();

	public void abrirTelaInicial() {
		tela.abrirTela();
	}

	@FXML
	public void abrirCadastrodeVendedorExternoAction(ActionEvent event) {
		cadastroTelaVendedorExternoService.abrirTela();
		TelaInicialService.fecharTela();
	}

	@FXML
	public void abrirListardeVendedorExternoAction(ActionEvent event) {
		listarTelaVendedorExternoService.abrirTela();
		TelaInicialService.fecharTela();
	}
	
	@FXML
	public void abrirAtualizardeVendedorExternoAction(ActionEvent event) {
		atualizarTelaVendedorExternoService.abrirTela();
		TelaInicialService.fecharTela();
	}
	
	

	@FXML
	public void abrirDeletardeVendedorExternoAction(ActionEvent event) {
		deletarTelaVendedorExterno.abrirTela();
		TelaInicialService.fecharTela();
	}
}
