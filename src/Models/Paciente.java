package Models;

public class Paciente extends Pessoa{
    private String cpf;
    private String telefone;
    private String tipo_atd;

    public Paciente(String cpf, String telefone, String nome) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public Paciente() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo_atd() {
        return tipo_atd;
    }

    public void setTipo_atd(String tipo_atd) {
        this.tipo_atd = tipo_atd;
    }

    @Override
    public String toString() {
        String format = String.format("--> %s \nTelefone: %s\nCPF: %s\n", this.getNome(),
                this.getTelefone(), this.getCpf());
        return format;
    }
    
    
}
