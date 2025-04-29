import com.desafiobancodio.banco.Cliente;
import com.desafiobancodio.banco.Conta;
import com.desafiobancodio.banco.ContaCorrente;
import com.desafiobancodio.banco.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Natan", "email@email.com");

        Conta cc = new ContaCorrente(cliente, "senha123");
        Conta poupanca = new ContaPoupanca(cliente, "senha456");

        cc.depositar(200);
        cc.transferir(150, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.changePassword("senha789");
        cc.imprimirExtrato();

    }

}