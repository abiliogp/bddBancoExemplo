package BDDBanco;

import java.util.Map;

public interface Conta {

  public void aberturaDeConta(Map<String, String> valoresCadastro);

  public void cadastrarCliente();

  public void setAgencia(String agencia);

  public String getAgencia();

  public String getConta();

  public String consultaExtrato();

  public Long consultaSaldo();

  public void depositarValor(long valor);

  public void debitarTaxa(int taxa);

  public String getNomeCliente();

}
