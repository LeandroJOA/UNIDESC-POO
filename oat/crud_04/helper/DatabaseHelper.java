package br.edu.unidesc.exercicio.oat.crud_04.helper;

import br.edu.unidesc.exercicio.oat.crud_04.banco.DataBaseConnection;
import br.edu.unidesc.exercicio.oat.crud_04.entidades.Aluno;

import java.sql.*;

public class DatabaseHelper {

    private static DatabaseHelper instance = null;

    //SINGLETON
    private DatabaseHelper() {

    }

    public static DatabaseHelper getInstance() {

        if (instance == null)
            instance = new DatabaseHelper();
        return instance;
    }

    public void criarAluno(Aluno aluno) {
        PreparedStatement comandoSql;

        try {
            //Comando de INSERT
            comandoSql = DataBaseConnection.getInstance().criarPreparedStatement(
                    "insert into aluno values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            //Atribuindo valores
            comandoSql.setString(1, aluno.getNome());
            comandoSql.setString(2, aluno.getCurso());
            comandoSql.setString(3, aluno.getCpf());
            comandoSql.setString(4, aluno.getMatricula());
            //Executando comando de INSERT
            comandoSql.executeUpdate();
            //Finalizando a operação
            comandoSql.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String lerAluno(String cpf) {
        //Capturando a conexão
        Connection connection = DataBaseConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            //Capturando o retorno do SELECT
            ResultSet rs = statement.executeQuery("SELECT * FROM aluno WHERE cpf = '" + cpf + "';");
            if(rs.next()) {
                //Retornando dados da linha encontrada
                return  rs.getString("nome") + "\n" +
                        rs.getString("curso") + "\n" +
                        rs.getString("cpf") + "\n" +
                        rs.getString("matricula");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void atualizarAluno(String cpf, String nome, String curso) {
        PreparedStatement comandoSql;

        try {
            //Comando para UPDATE
            comandoSql = DataBaseConnection.getInstance().criarPreparedStatement(
                    "update aluno set nome = ?, curso = ? where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            //Atribuindo valores
            comandoSql.setString(1, nome);
            comandoSql.setString(2, curso);
            comandoSql.setString(3, cpf);
            //Executando UPDATE
            comandoSql.executeUpdate();
            //Finalizando operação
            comandoSql.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean deletarAluno(String cpf) {
        PreparedStatement comandoSql;

        try {
            //Comando para DELETR
            comandoSql = DataBaseConnection.getInstance().criarPreparedStatement(
                    "delete from aluno where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            //Atribuindo valores
            comandoSql.setString(1, cpf);
            //Executando DELETE
            comandoSql.execute();
            //Finalizando operação
            comandoSql.close();
            //Remoção bem sucedida
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            //Remoção mal sucedida
            return false;
        }
    }
}
