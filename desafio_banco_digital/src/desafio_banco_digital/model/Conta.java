package desafio_banco_digital.model;

import java.util.Objects;

import desafio_banco_digital.interfaces.OperacoesConta;

public class Conta implements OperacoesConta {

	protected String numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(String numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}

	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Depósito de R$" + valor + " realizado na conta " + numero);
		} else {
			System.out.println("Valor inválido para depósito.");
		}
	}

	@Override
	public boolean sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.println("Saque de R$" + valor + " realizado na conta " + numero);
			return true;
		} else {
			System.out.println("Saldo insuficiente ou valor inválido para saque.");
			return false;
		}
	}

	@Override
	public boolean transferir(Conta destino, double valor) {
		if (this.sacar(valor)) {
			destino.depositar(valor);
			System.out.println("Transferência de R$ " + valor + " realizada para a conta " + destino.getNumero());
			return true;
		} else {
			System.out.println("Transferência falhou.");
			return false;
		}
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}

}
