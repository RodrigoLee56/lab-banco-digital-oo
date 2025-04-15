package desafio_banco_digital.model;

import java.util.ArrayList;
import java.util.List;

import desafio_banco_digital.interfaces.IBanco;

public class Banco implements IBanco {
	private List<Conta> contas;

	public Banco() {
		this.contas = new ArrayList<>();
	}

	@Override
	public void adicionarConta(Conta conta) {
		if (!contas.contains(conta)) {
			contas.add(conta);
			conta.getCliente().adicionarConta(conta);
			System.out.println("Conta adicionada ao banco: " + conta.getNumero());
		} else {
			System.out.println("A conta já está registrada no banco.");
		}
	}

	@Override
	public Conta buscarConta(String numero) {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		System.out.println("Conta não encontrada.");
		return null;
	}

	@Override
	public void removerConta(String numero) {
		Conta conta = buscarConta(numero);
		if (conta != null) {
			contas.remove(conta);
			conta.getCliente().removerConta(conta);
			System.out.println("Conta removida do banco: " + numero);
		} else {
			System.out.println("Conta não encontrada para remoção.");
		}
	}

	@Override
	public List<Conta> buscarContas(Cliente cliente) {
		List<Conta> contasDoCliente = new ArrayList<>();
		for (Conta conta : contasDoCliente) {
			if (conta.getCliente().getCpf().equals(cliente.getCpf())) {
				contasDoCliente.add(conta);
			}
		}
		return contasDoCliente;
	}

}
