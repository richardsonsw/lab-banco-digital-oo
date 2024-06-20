
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente, Banco banco, TipoConta tipoConta) {
		super(cliente, banco, tipoConta);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
