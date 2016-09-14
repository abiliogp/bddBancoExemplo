package BDDBanco;

import java.io.File;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class US001_ManterContaBancariaStep {

	private Conta conta;

	private String nomeCliente;

	@Dado("^as informações do cliente$")
	public void as_informações_do_cliente(Map<String, String> valores) throws Throwable {
		conta = new ContaCorrente();
		conta.aberturaDeConta(valores);
	}

	@Quando("^cadastrar a conta do cliente no Banco BDD$")
	public void cadastrar_a_conta_do_cliente_no_Banco_BDD() throws Throwable {
		Banco.getInstance().addNovaConta(conta);
	}

	@Entao("^devo receber um número de agência$")
	public void devo_receber_um_número_de_agência() throws Throwable {
		String agencia = Banco.getInstance().getContaOperante().getAgencia();
		Assert.assertFalse(agencia.isEmpty());
	}

	@Entao("^um número da conta$")
	public void um_número_da_conta() throws Throwable {
		String conta = Banco.getInstance().getContaOperante().getConta();
		Assert.assertFalse(conta.isEmpty());
	}

	@Dado("^um nome de um cliente \"([^\"]*)\"$")
	public void um_nome_de_um_cliente(String nomeCliente) throws Throwable {
		this.nomeCliente = nomeCliente;
	}

	@Quando("^buscar a conta$")
	public void buscar_a_conta() throws Throwable {
		conta = Banco.getInstance().buscarClientePeloNome(this.nomeCliente);
	}

	@Então("^devo receber um número válido$")
	public void devo_receber_um_número_válido() throws Throwable {
		Assert.assertTrue(Banco.getInstance().getContaOperante().getConta() != null);
	}

	@Então("^devo receber um comprovante$")
	public void devo_receber_um_comprovante() throws Throwable {
		Assert.assertTrue(new File("comprovanteDeposito").exists());

	}

}
