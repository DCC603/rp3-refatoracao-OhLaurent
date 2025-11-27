import java.util.ArrayList;
import java.util.List;

public class Extrato {
    private List<Operacao> operacoes;

    public Extrato() {
        this.operacoes = new ArrayList<>();
    }

    public void adicionarOperacao(Operacao operacao) {
        this.operacoes.add(operacao);
    }

    @Override
    public String toString() {
        String dadosExtrato = "";
        for (Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }
        return dadosExtrato;
    }
}
