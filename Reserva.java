package airbnb;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    Propriedade propriedade;
    Usuario usuario;
    LocalDate entrada;
    LocalDate saida;
    double custoTotal;

    public Reserva(Propriedade propriedade, Usuario usuario, LocalDate entrada, LocalDate saida) {
        this.propriedade = propriedade;
        this.usuario = usuario;
        this.entrada = entrada;
        this.saida = saida;

        calcularCustoTotal();
    }

    public void fazerReserva() {
        if (saida.isAfter(entrada)) {
            calcularCustoTotal();
            System.out.println("Reservado");
        } else {
            System.out.println("Data inválida.");
        }
    }

    public void calcularCustoTotal() {
        long noites = ChronoUnit.DAYS.between(entrada, saida);
        custoTotal = noites * propriedade.preco_por_noite;
    }

    public void imprimirDados() {
        System.out.println("Usuário: " + usuario.nome);
        System.out.println("Propriedade: " + propriedade.titulo);
        System.out.println("Check-in: " + entrada);
        System.out.println("Check-out: " + saida);
        System.out.println("Custo total: R$ " + custoTotal);
    }
}