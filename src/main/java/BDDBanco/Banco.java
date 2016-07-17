package BDDBanco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;

public class Banco {

	private static Banco instance;

	private static LinkedList<Conta> contas;

	private static Integer agencia = 100;

	private Banco() {
		contas = new LinkedList<Conta>();
		agencia++;
	}

	public static Banco getInstance() {
		if (instance == null) {
			instance = new Banco();
		}
		return instance;
	}

	public String getAgencia() {
		return agencia.toString();
	}

	public Conta getContaOperante() {
		return contas.getLast();
	}

	public void addNovaConta(Conta conta) {
		conta.setAgencia(agencia.toString());
		contas.add(conta);
	}

	public Conta buscarClientePeloNome(String nomeCliente) {
		for (Conta conta : contas) {
			if (conta.getNomeCliente().equals(nomeCliente)) {
				return conta;
			}
		}
		return null;
	}

	public void depositarValor(Conta conta, long deposito) {
		conta.depositarValor(deposito);
		gerarComprovante(conta, deposito);
	}

	private void gerarComprovante(Conta conta, long deposito) {
		StringBuilder comprovante = new StringBuilder();
		comprovante.append("Data ");
		comprovante.append(Calendar.getInstance().getTime());
		comprovante.append("\n");
		comprovante.append("Favorecido: ");
		comprovante.append(conta.getNomeCliente());
		comprovante.append("\n");
		comprovante.append("Valor: ");
		comprovante.append(deposito);
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("comprovanteDeposito"));
			out.write(comprovante.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void gravarContas() {
		StringBuilder str = new StringBuilder();
		for (Conta conta : contas) {
			str.append(conta.toString());
		}
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("contasAgencia" + agencia));
			out.write(str.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
