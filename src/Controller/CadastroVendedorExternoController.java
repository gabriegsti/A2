package Controller;

import java.time.LocalDate;


import Model.Pessoa;
import Service.CadastroVendedorExternoService;
import Service.TelaInicialService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroVendedorExternoController {
	
	TelaInicialService telaInicial = new TelaInicialService();
	CadastroVendedorExternoService telaVendedorExternoCadastro = new CadastroVendedorExternoService();
    
	@FXML
    private TextField nometxt;

    @FXML
    private TextField telefonetxt;

    @FXML
    private TextField dataDeNascimentotxt;

    @FXML
    private TextField salariotxt;

    @FXML
    private TextField comissaotxt;

    @FXML
    private TextField ajudaDeCustotxt;

    @FXML
    private TextField clienteNometxt;

    @FXML
    private TextField clienteDataDeNascimentotxt;

    @FXML
    private TextField ClienteTelefonetxt;
	
    
    
    @FXML
	private void VoltarParaTelaInicialAction(ActionEvent event) {
		telaInicial.abrirTela();
		CadastroVendedorExternoService.fecharTela();
	}
    
    //Salvar os dados em memória no arquivo
    @FXML
   	private void SalvarVendedorExternoAction(ActionEvent event) {
    	telaVendedorExternoCadastro.Salvar();
    }
    
    //Este método recebe os dados diretametne informados pelo usuario na view e repassa para o service armazenar em memória
    @FXML
   	private void CadastrarVendedorExternoAction(ActionEvent event) {
    	String nome;
    	String telefone;
    	LocalDate dataDeNascimento;
    	double salario;
    	double comissao;
    	double ajudaDeCusto;
    	String clienteNome;
    	LocalDate clienteDataDeNascimento;
    	String clienteTelefone;
    	
    	nome = nometxt.getText().trim();
    	telefone = telefonetxt.getText().trim();
    	dataDeNascimento = LocalDate.parse(dataDeNascimentotxt.getText().trim(), Pessoa.formatter);
    	salario = Double.parseDouble(salariotxt.getText().trim());
    	comissao = Double.parseDouble(comissaotxt.getText().trim());
    	ajudaDeCusto = Double.parseDouble(ajudaDeCustotxt.getText().trim());
    	clienteNome = clienteNometxt.getText().trim();
    	clienteDataDeNascimento = LocalDate.parse(clienteDataDeNascimentotxt.getText().trim(), Pessoa.formatter);
    	clienteTelefone = ClienteTelefonetxt.getText().trim();
    	
    	telaVendedorExternoCadastro.CadastrarVendedorExterno(nome, telefone,
    			dataDeNascimento, salario, comissao, ajudaDeCusto, clienteNome
    			,clienteTelefone,clienteDataDeNascimento);
   	}
    
}
