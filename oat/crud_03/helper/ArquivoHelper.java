package br.edu.unidesc.exercicio.oat.crud_03.helper;

import br.edu.unidesc.exercicio.oat.crud_03.entidades.Aluno;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ArquivoHelper {

    private String caminho = "alunos.csv";
    private String separador = ",";
    private static ArquivoHelper instance = null;

    //SINGLETON
    private ArquivoHelper() {

    }

    public static ArquivoHelper getInstance() {

        if (instance == null)
            instance = new ArquivoHelper();
        return instance;
    }

    //Metodo para gravar arquivo CSV
    public void gravarCSV(Aluno aluno) {

        //Formatando os dados a serem gravados
        StringBuilder builder = new StringBuilder();
        builder.append(aluno.getNome())
                .append(separador)
                .append(aluno.getCpf())
                .append(separador)
                .append(aluno.getCurso())
                .append(separador)
                .append(aluno.getMatricula());

        try {
            //Criando arquivo, caso não exista
            FileWriter writer = new FileWriter(caminho, true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            //Gravando arquivo com dados formatados
            bWriter.write(builder.toString());
            bWriter.newLine();
            bWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    //Metodo para ler arquivo CSV
    public String lerCSV() {

        //Arquivo a ser lido
        File file = new File(caminho);

        try {
            //Retornando String com o conteudo do arquivo
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (FileNotFoundException exception) {
            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    //Metodo para deletar arquivo CSV
    public boolean deletarCSV() {

        //Arquivo a ser deletado
        File file = new File(caminho);

        //Retornando se a exclusão ocorreu ou não
        return file.delete();
    }
}