package BDDBanco;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class US002_DepositarUmValorNaContaBancariaStep {

  private Conta  conta;

  private String nomeDoCliente;

  @Dado("^um cliente com nome de \"([^\"]*)\"$")
  public void um_cliente_com_nome_de(String nomeDoCliente) throws Throwable {
    Map<String, String> dadosDoCliente = new FabricaDeCliente().criarCliente(nomeDoCliente);
    conta = new ContaCorrente();
    conta.aberturaDeConta(dadosDoCliente);
    this.nomeDoCliente = nomeDoCliente;
    Banco.getInstance().addNovaConta(conta);
  }

}
