import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        int numeroUm = terminal.nextInt();
        System.out.println("Digite o segundo número:");
        int numeroDois = terminal.nextInt();

        try {
            // chamando o método contendo a lógica de contagem
            contar(numeroUm, numeroDois);
        } catch (ParametrosInvalidosException exception) {
            // imprimir a mensagem: O segundo número deve ser maior que o primeiro
            System.out.println("O segundo número deve ser maior que o primeiro");
        }
    }

    static void contar(int numeroUm, int numeroDois) throws ParametrosInvalidosException {
        // validar se númeroUm é MAIOR que númeroDois e lançar a exceção
        if (numeroUm > numeroDois) {
            throw new ParametrosInvalidosException();
        }

        int contagem = numeroDois - numeroUm;
        // realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

class ParametrosInvalidosException extends Exception {
}
