import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "JOÃO", "ANA", "CARLOS", "MARIA", "PEDRO", "LUCAS", "JULIA", "GABRIEL", "LARISSA", "RAFAEL"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);

        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;

            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while (continuarTentando && tentativasRealizadas < 3);
        if(atendeu)
            System.out.println("CONSEGUMOS CONTATO COM O CANDIDATO "+candidato+" NA "+ tentativasRealizadas+" TENTATIVAS");
        else
            System.out.println("NÃO CONSEGUEM CONSEGUIMOS CONTATO COM "+candidato+" NÚMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas+" REALIZADAS");
    }
    
    //método auxiliar
        static boolean atender(){
        return new Random().nextInt(3)==1;
        }

    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MARCIA", "JOÃO", "ANA", "CARLOS", "MARIA", "PEDRO", "LUCAS", "JULIA", "GABRIEL", "LARISSA", "RAFAEL"};


        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº" + (indice + 1) + " é " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "JOÃO", "ANA", "CARLOS", "MARIA", "PEDRO", "LUCAS", "JULIA", "GABRIEL", "LARISSA", "RAFAEL"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
