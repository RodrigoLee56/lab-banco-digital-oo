package desafio_banco_digital.model;

public class ContaPoupanca extends Conta {
	private double taxaRendimento;

	public ContaPoupanca(String numero, Cliente cliente, double taxaRendimento) {
		super(numero, cliente);
		this.taxaRendimento = taxaRendimento;
	}

	public void render() {
		double rendimento = getSaldo() * taxaRendimento;
		depositar(rendimento);
		System.out.println("Rendimento aplicado: R$" + rendimento + ". Novo saldo: R$" + getSaldo());

	}
}
