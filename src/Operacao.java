public abstract class Operacao {

    private double valor;

    public Operacao(double valor) {
        this.valor = valor;
    }

    public abstract String getTipo();

    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
