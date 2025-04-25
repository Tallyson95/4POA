package agenda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private final String ARQUIVO = "agenda.txt";
    private List<Contato> contatos;

    public ContatoDAO() {
        contatos = carregarContatosDoArquivo();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        salvarContatosNoArquivo();
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public void removerContato(String nome) {
        contatos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
        salvarContatosNoArquivo();
    }

    private void salvarContatosNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Contato c : contatos) {
                writer.write(c.getNome() + ";" + c.getTelefone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    private List<Contato> carregarContatosDoArquivo() {
        List<Contato> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    lista.add(new Contato(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }

        return lista;
    }
}
