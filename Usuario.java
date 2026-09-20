public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public Usuario(String nome, String email, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo == 1) {
            this.tipo = "Locador";
        } else {
            this.tipo = "Locatário";
        }
        
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Senha: " + "*".repeat(senha != null ? senha.length() : 0));
        System.out.println("Tipo: " + tipo);
        System.out.println("");
    }
}