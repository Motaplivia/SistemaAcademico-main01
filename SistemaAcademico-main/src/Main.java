import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Disciplina> disciplinaList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("*******************************");
            System.out.println("Bem-vindo ao Sistema Acadêmico!");
            System.out.println("*******************************");

            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Cadastrar disciplina");
            System.out.println("2. Cadastrar professor e associar à disciplina");
            System.out.println("3. Listar turmas por disciplina");
            System.out.println("4. Sair\n");

            int op = input.nextInt();
            input.nextLine(); // Consome a nova linha

            if (op == 1) {
                Disciplina novaDisciplina = Disciplina.cadastrarDisciplina();
                disciplinaList.add(novaDisciplina);

            } else if (op == 2) {
                System.out.println("Informe o código do professor:");
                int idProfessor = input.nextInt();
                input.nextLine();

                System.out.println("Informe o nome do professor:");
                String nomeProfessor = input.nextLine();

                Professor novoProfessor = new Professor(idProfessor, nomeProfessor);

                System.out.println("Selecione a disciplina para associar o professor:");
                for (Disciplina disciplina : disciplinaList) {
                    System.out.println(disciplina.getIdDisciplina() + ": " + disciplina.getNomeDisciplina());
                }

                int idDisciplinaEscolhida = input.nextInt();
                input.nextLine();

                for (Disciplina disciplina : disciplinaList) {
                    if (disciplina.getIdDisciplina() == idDisciplinaEscolhida) {
                        disciplina.setProfessor(novoProfessor); // Associa o professor à disciplina
                        System.out.println("Professor associado à disciplina " + disciplina.getNomeDisciplina());
                        break;
                    }
                }


            } else if (op == 3) {
                System.out.println("Lista de turmas por disciplina:");
                for (Disciplina disciplina : disciplinaList) {
                    System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
                    for (Turma turma : disciplina.getTurmas()) {
                        System.out.println("Turma: " + turma.getNomeTurma());
                    }
                }

            } else if (op == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Escolha uma opção válida.");
            }
        }
    }
}
