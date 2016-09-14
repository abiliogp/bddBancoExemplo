package BDDBanco;

import java.util.Map;

public class ContaCorrente implements Conta {

  private Cliente        cliente;

  private static Integer conta = 10000;

  private String         agencia;

  private Long           saldo = 0L;

  public ContaCorrente() {
    this.cliente = new Cliente();
    conta++;
  }

  public void aberturaDeConta(Map<String, String> valoresCadastro) {
    this.cliente.setValores(valoresCadastro);
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getAgencia() {
    return agencia;
  }

  public String getConta() {
    return conta.toString();
  }

  public String getNomeCliente() {
    return this.cliente.getNome();
  }

  public void cadastrarCliente() {
    // TODO Auto-generated method stub

  }

  public String consultaExtrato() {
    // TODO Auto-generated method stub
    return null;
  }

  public Long consultaSaldo() {
    return saldo;
  }

  public void depositarValor(long valor) {
    this.saldo += valor;
  }

  public void debitarTaxa(int taxa) {
    // TODO Auto-generated method stub

  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Cliente:");
    str.append("\n");
    str.append(cliente.toString());
    str.append("\n");
    str.append("Dados da Conta:");
    str.append("\n");
    str.append("Agência: " + agencia);
    str.append("-");
    str.append(" Conta: " + conta);
    str.append("\n------------------");
    return str.toString();
  }
}
