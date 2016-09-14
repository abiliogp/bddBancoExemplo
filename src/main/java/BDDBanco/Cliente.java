package BDDBanco;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Cliente {

	private String nome;
	private String nascimento;
	private String rg;
	private String cpf;
	private String endereco;
	private String profissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setValores(Map<String, String> valores) {
		for (String chave : valores.keySet()) {
			try {
				BeanUtils.setProperty(this, chave, valores.get(chave));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + nome);
		str.append("\n");
		str.append("CPF: " + cpf);
		str.append("\n");
		str.append("RG: " + rg);
		str.append("\n");
		str.append("Endereço:" + rg);
		str.append("\n");
		str.append("Profissão:" + profissao);
		str.append("\n");
		return str.toString();
	}

}
