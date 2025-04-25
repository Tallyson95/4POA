package agenda;

import java.util.List;

public class ContatoService {
    private ContatoDAO contatoDAO = new ContatoDAO();

    public void adicionarContato(String nome, String telefone) {
        contatoDAO.adicionarContato(new Contato(nome, telefone));
    }

    public List<Contato> listarContatos() {
        return contatoDAO.listarContatos();
    }

    public void removerContato(String nome) {
        contatoDAO.removerContato(nome);
    }
}
