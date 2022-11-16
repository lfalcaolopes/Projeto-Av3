public class Usuario {
    private String nome;
    private int cpf;
    private String dataNasc;
    private char sexo;
    private String telefone;

    public Usuario(String nome, int cpf, String dataNasc, char sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
