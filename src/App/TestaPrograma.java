package App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

import Model.ClienteExterno;
import Model.Pessoa;
import Model.VendedorExterno;

public class TestaPrograma {
 public static void main(String[] args) {
	TreeSet<VendedorExterno> v = new TreeSet<VendedorExterno>();
	int id;
	String nome;
	String telefone;
	LocalDate dataDeNascimento;
	double salario;
	double comissao;
	double ajudaCusto;

	ClienteExterno cliente = new ClienteExterno(1, "Gustavo","2569696", LocalDate.parse("16/09/2020", Pessoa.formatter)  );
	VendedorExterno v1 = new VendedorExterno(1, "Gabriel", "25696969", LocalDate.parse("16/09/2020", Pessoa.formatter), 1300.00, 500.00, cliente); 
}
}
