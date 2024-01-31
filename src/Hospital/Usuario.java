package Hospital;

public class Usuario extends Pessoa {
    private int id;
    private String login;
    private String senha;
    private String especialidade;
    private int status_lg;

    public Usuario(String login, String senha, String nome) {
        super(nome);
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(){}


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getStatus_lg() {
        return status_lg;
    }

    public void setStatus_lg(int status_lg) {
        this.status_lg = status_lg;
    }
    
}
