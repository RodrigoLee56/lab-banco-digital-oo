package desafio_banco_digital.interfaces;

import desafio_banco_digital.model.Conta;

public interface OperacoesConta {
	void depositar(double valor);

	boolean sacar(double valor);

	boolean transferir(Conta destino, double valor);
}
