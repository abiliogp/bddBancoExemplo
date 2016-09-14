package BDDBanco;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class US002_DepositarUmValorNaContaBancariaStep {

	private Conta conta;

	private String nomeDoCliente;

	private Long saldoAntesDoDeposito;

	private Long valorDoDeposito;

	@Dado("^um cliente com nome de \"([^\"]*)\"$")
	public void um_cliente_com_nome_de(String nomeDoCliente) throws Throwable {
		Map<String, String> dadosDoCliente = new FabricaDeCliente().criarCliente(nomeDoCliente);
		conta = new ContaCorrente();
		conta.aberturaDeConta(dadosDoCliente);
		this.nomeDoCliente = nomeDoCliente;
		Banco.getInstance().addNovaConta(conta);
	}

	@Dado("^um valor para deposito (\\d+) reais$")
	public void um_valor_para_deposito_reais(Long valorDoDeposito) throws Throwable {
		this.saldoAntesDoDeposito = conta.consultaSaldo();
		this.valorDoDeposito = valorDoDeposito;
	}

	@Quando("^depositar o valor$")
	public void depositar_o_valor() throws Throwable {
		Conta conta = Banco.getInstance().buscarClientePeloNome(this.nomeDoCliente);

		conta.depositarValor(this.valorDoDeposito);
	}

	@Então("^o saldo da conta deve aumentar em (\\d+) reais$")
	public void o_saldo_da_conta_deve_aumentar_em_reais(Long valorDeposito) throws Throwable {
		Long saldoEsperado = saldoAntesDoDeposito + valorDeposito;
		Conta conta = Banco.getInstance().buscarClientePeloNome(this.nomeDoCliente);

		Assert.assertEquals(saldoEsperado, conta.consultaSaldo());
	}

}
