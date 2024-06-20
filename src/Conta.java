
public abstract class Conta implements IConta {
	
	@SuppressWarnings("unused")
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected Banco agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private TipoConta tipoConta;

	public Conta(Cliente cliente, Banco agencia, TipoConta tipoConta) {
		this.agencia = agencia;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
	}
	
	public Conta(Cliente cliente, Banco agencia) {
		this.agencia = agencia;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = TipoConta.START;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public Banco getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia.getNumeroAgencia()));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}
