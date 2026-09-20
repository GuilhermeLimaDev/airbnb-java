public class Propriedade{
    boolean disponibilidade;
    String titulo;
    String descricao;
    String localizacao;
    int capacidade;
    float preco_por_noite;
    Usuario proprietario;

    public Propriedade(boolean disponibilidade, String titulo, String descricao, String localizacao, int capacidade, float preco_por_noite, Usuario proprietario){
        this.disponibilidade = disponibilidade;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.preco_por_noite = preco_por_noite;
        this.proprietario = proprietario;
    }
    public boolean disponibilidade(){
        return disponibilidade;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getLocalizacao(){
        return localizacao;
    }
    public int getCapacidade(){
        return capacidade;
    }
    public float preco_por_noite(){
        return preco_por_noite;
    }
    public Usuario proprietario(){
        return proprietario;
    }
    public void imprimirDados() {
    System.out.println("Título: " + titulo);
    System.out.println("Descrição: " + descricao);
    System.out.println("Localização: " + localizacao);
    System.out.println("Capacidade: " + capacidade);
    System.out.println("Preço por noite: R$ " + preco_por_noite);
    System.out.println("Proprietário: " + proprietario.getNome());
    System.out.println("Disponível: " + disponibilidade);
    System.out.println("");
    }


}