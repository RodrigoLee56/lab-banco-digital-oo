package desafio_banco_digital.app;

import java.util.List;

import desafio_banco_digital.model.Banco;
import desafio_banco_digital.model.Cliente;
import desafio_banco_digital.model.Conta;
import desafio_banco_digital.model.ContaCorrente;
import desafio_banco_digital.model.ContaPoupanca;

public class BancoApp {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "Rua A, 123");
		Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00", "Rua B, 456");

		Banco banco = new Banco();

		Conta contaCorrente = new ContaCorrente("CC123", cliente1, 500.0);
		Conta contaPoupanca = new ContaPoupanca("CP456", cliente2, 0.01);

		banco.adicionarConta(contaPoupanca);
		banco.adicionarConta(contaCorrente);

		contaCorrente.depositar(1000.0);
		contaCorrente.sacar(300.0);
		contaCorrente.transferir(contaPoupanca, 200.0);

		((ContaPoupanca) contaPoupanca).render();
		
		List<Conta> contasDoCliente1 = banco.buscarContas(cliente1);
        System.out.println("Contas do cliente " + cliente1.getNome() + ":");
        for (Conta conta : contasDoCliente1) {
            System.out.println("- Conta: " + conta.getNumero() + ", Saldo: R$" + conta.getSaldo());
        }
        
        banco.removerConta("CP456");
	}

}
