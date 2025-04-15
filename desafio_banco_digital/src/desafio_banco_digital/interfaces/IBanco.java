package desafio_banco_digital.interfaces;

import java.util.List;

import desafio_banco_digital.model.Cliente;
import desafio_banco_digital.model.Conta;

public interface IBanco {
	void adicionarConta(Conta conta);

	Conta buscarConta(String numero);

	void removerConta(String numero);

	List<Conta> buscarContas(Cliente cliente);
}
