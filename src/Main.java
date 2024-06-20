
public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, banco, TipoConta.PRIME);
		Conta poupanca = new ContaPoupanca(venilton, banco);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
