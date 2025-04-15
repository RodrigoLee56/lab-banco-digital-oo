package desafio_banco_digital.model;

public class ContaCorrente extends Conta {
	private double limite;

	public ContaCorrente(String numero, Cliente cliente, double limite) {
		super(numero, cliente);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	@Override
	public boolean sacar(double valor) {
		if (valor > 0 && valor <= getSaldo() + limite) {
			setSaldo(valor);
			return true;
		} else {
			return false;
		}
	}
	
	private void setSaldo(double novoSaldo){
		super.sacar(novoSaldo);
	}

}
