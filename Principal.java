import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Usuario locador = new Usuario(null, null, null, null);
        Usuario locatario = new Usuario(null, null, null, null);
        Propriedade propriedade = new Propriedade(true, null, null, null, 0, 0, null);
        ArrayList<Reserva> reservas = new ArrayList<>();

        int opcaoTipoUsuario;
        int opcaoMenu;
        boolean locadorCriado = false;
        boolean locatarioCriado = false;
        boolean propriedadeCriada = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, bem vindo a sua melhor solução de locação e hospedagem!");
        System.out.println("Como podemos te ajudar hoje?");
        System.out.println("");

        do {
            System.out.println("USUÁRIOS ________________");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Exibir dados dos usuários");
            System.out.println("");
            System.out.println("PROPRIEDADES ____________");
            System.out.println("3 - Criar propriedade");
            System.out.println("4 - Exibir dados da propriedade");
            System.out.println("");
            System.out.println("RESERVAS ________________");
            System.out.println("5 - Criar reserva");
            System.out.println("6 - Listar reservas");
            System.out.println("");
            System.out.println("7 - Encerrar");

            System.out.print("Escolha sua opção: ");
            opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("Certo, vamos prosseguir com a criação de usuário!");
                    System.out.println("Qual o tipo de usuário?");
                    System.out.println("1 - Locador");
                    System.out.println("2 - Locatário");
                    do {
                        opcaoTipoUsuario = scanner.nextInt();
                        if (opcaoTipoUsuario != 1 && opcaoTipoUsuario != 2) {
                            System.out.println("Opção invalida, tente novamente!");
                        }
                    } while (opcaoTipoUsuario != 1 && opcaoTipoUsuario != 2);

                    if (opcaoTipoUsuario == 1) {
                        locador.setTipo(opcaoTipoUsuario);
                        System.out.print("Primeiro, insira o nome do usuário: ");
                        locador.setNome(scanner.next());
                        System.out.print("Agora, insira o e-mail do usuário: ");
                        locador.setEmail(scanner.next());
                        System.out.print("Por último, insira a senha do usuário: ");
                        locador.setSenha(scanner.next());
                        System.out.println("");
                        System.out.println("Usuário criado com sucesso!");
                        System.out.println("Sugestão: Em seguida, cadastre sua propriedade para alocação!");
                        locadorCriado = true;
                    } else {
                        locatario.setTipo(opcaoTipoUsuario);
                        System.out.print("Primeiro, insira o nome do usuário: ");
                        locatario.setNome(scanner.next());
                        System.out.print("Agora, insira o e-mail do usuário: ");
                        locatario.setEmail(scanner.next());
                        System.out.print("Por último, insira a senha do usuário: ");
                        locatario.setSenha(scanner.next());
                        System.out.println("");
                        System.out.println("Usuário criado com sucesso!");
                        System.out.println("Sugestão: Em seguida, cadastre sua propriedade para alocação!");
                        locatarioCriado = true;
                    }
                    System.out.println("");
                    
                    break;

                case 2:
                    if (!locadorCriado && !locatarioCriado) {
                        System.out.println("Nenhum usuário cadastrado, voltando ao menu!");
                    } else {
                        System.out.println("Claro, aqui estão os dados dos usuários cadastrados!");
                        if (locadorCriado) {
                            locador.imprimirDados();
                        }

                        if (locatarioCriado) {
                            locatario.imprimirDados();
                        }
                    } 
                    break;

                case 3:
                    if (!locadorCriado) {
                        System.out.println("Crie um usuário locador para acessar essa função! Voltando ao menu.");
                        System.out.println("");
                    } else {
                        System.out.println("Certo, vamos prosseguir com a criação de propriedade!");
                        System.out.println("");
                        System.out.print("Primeiro, insira o título do anúncio: ");
                        System.out.println("");
                        propriedade.titulo = scanner.next();
                        System.out.println("");
                        System.out.print("Agora, insira a descrição do anúncio: ");
                        System.out.println("");
                        propriedade.descricao = scanner.next();
                        System.out.print("Em seguida, a localização da propriedade: ");
                        System.out.println("");
                        propriedade.localizacao = scanner.next();
                        System.out.print("Descreva, em número, a capacidade da propriedade: ");
                        System.out.println("");
                        propriedade.capacidade = scanner.nextInt();
                        System.out.print("Para finalizar, o preço por noite: ");
                        System.out.println("");
                        propriedade.preco_por_noite = scanner.nextFloat();
                        propriedade.proprietario = locador;
                        System.out.println("");
                        System.out.println("Propriedade de " + locador.getNome() + " cadastrada com sucesso!");
                        System.out.println("");
                        propriedadeCriada = true;
                    }
                    break;

                case 4:
                    if (!propriedadeCriada) {
                        System.out.println("Crie uma propriedade antes de acessar essa função! voltando ao menu.");
                    } else {
                        System.out.println("Aqui estão os dados da propriedade cadastrada!");
                        propriedade.imprimirDados();
                    }
                    break;

                case 5:
                    if (!locatarioCriado || !propriedadeCriada) {
                        System.out.println("Cadastre um locatário e uma propriedade antes de criar uma reserva!");
                        break;
                    }

                    try {
                        System.out.print("Insira a data de entrada (AAAA-MM-DD): ");
                        LocalDate entrada = LocalDate.parse(scanner.next());
                        System.out.print("Insira a data de saída (AAAA-MM-DD): ");
                        LocalDate saida = LocalDate.parse(scanner.next());

                        if (!saida.isAfter(entrada)) {
                            System.out.println("A data de saída deve ser posterior à data de entrada!");
                            break;
                        }

                        Reserva reserva = new Reserva(propriedade, locatario, entrada, saida);
                        reserva.fazerReserva();
                        reservas.add(reserva);
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida! Use o formato AAAA-MM-DD com uma data válida.");
                    }
                    break;

                case 6:
                    if (reservas.isEmpty()) {
                        System.out.println("Nenhuma reserva cadastrada!");
                    } else {
                        for (Reserva reserva : reservas) {
                            reserva.imprimirDados();
                            System.out.println("");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Obrigado pela preferência!");
                    System.out.println("Encerrando...");
                    break;
            
                default:
                    System.out.println("Opção inválida, escolha novamente, por favor!");
                    break;
            }

        } while (opcaoMenu != 7);

        scanner.close();
    }
    
}