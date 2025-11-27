public class Conta {

    private Cliente cliente;
    private DadosConta dadosConta;
    private double saldo;
    private Extrato extrato;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double saldoInicial) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.dadosConta = new DadosConta(numAgencia, numConta, gerente);
        this.saldo = saldoInicial;
        this.extrato = new Extrato();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void realizarOperacao(char tipo, int valor) {
        Operacao op;
        if (tipo == 'd') {
            op = new Deposito(valor);
            depositar(valor);
        } else if (tipo == 's') {
            op = new Saque(valor);
            sacar(valor);
        } else {
            return;
        }
        this.extrato.adicionarOperacao(op);
    }

    private void depositar(double valor) {
        this.saldo += valor;
    }

    private void sacar(double valor) {
        this.saldo -= valor;
    }

    public String toString() {
        String dadosCliente = this.cliente.toString();
        String dadosConta = this.dadosConta.toString(this.saldo);
        String dadosExtrato = this.extrato.toString();

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
