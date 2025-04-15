package desafio_banco_digital.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private String endereco;
	private List<Conta> contas;

	public Cliente(String nome, String cpf, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		if (!contas.contains(conta)) {
			contas.add(conta);
			System.out.println("Conta adicionada ao cliente: " + conta.getNumero());
		} else {
			System.out.println("A conta já está associada ao cliente.");
		}
	}

	public void removerConta(Conta conta) {
		if (contas.remove(conta)) {
			System.out.println("Conta removida do cliente: "+conta.getNumero());
		}else {
			System.out.println("A conta não está associada ao cliente.");
		}
	}

}
