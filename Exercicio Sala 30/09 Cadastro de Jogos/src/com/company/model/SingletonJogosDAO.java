package com.company.model;

import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonJogosDAO {
    private Connection connection;
    private static SingletonJogosDAO instance = null;
    public static SingletonJogosDAO getInstance(){
        if(instance == null){
            instance = new SingletonJogosDAO();
        }
        return instance;
    }

    private SingletonJogosDAO(){
        try{
            connection = DriverManager.getConnection(Constants.kUrlBanco);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    private final String kTableName = "Jogos";
    private final String kSelectAllSql = "SELECT * from " + kTableName + ";";
    public final String kInsertGame = "INSERT INTO " + kTableName + " VALUES (?,?,?,?,?);";
    private final String selectName(String nome){
        return "SELECT * from " + kTableName + " WHERE nome = '"+ nome + "';";
    }
    private final String kUpdateGame(Jogo jogo){
        return "UPDATE "+ kTableName + " SET nome=\"" + jogo.nome + "\"," +
                "genero=\"" + jogo.genero + "\"," +
                "plataforma=\"" + jogo.plataforma + "\","+
                "lancamento=\"" + jogo.lancamento + "\""+
                " WHERE id = " +jogo.getId()+ ";";
    }

    public final String kDeleteJogo(Jogo jogo){
        return "DELETE FROM " + kTableName + " WHERE id= " + jogo.getId()+";";
    }
    public List<Jogo> getAll(){
        List<Jogo> jogos = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(kSelectAllSql);
            while(rs.next()){
                Jogo jogo = new Jogo(rs.getInt("id"));
                jogo.nome = rs.getString("nome");
                jogo.genero = rs.getString("genero");
                jogo.plataforma = rs.getString("plataforma");
                jogo.lancamento = rs.getString("lancamento");
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return jogos;
    }

    public boolean insertGame(Jogo jogo){
        PreparedStatement comandoSQL;
        try{
            comandoSQL = connection.prepareStatement(kInsertGame);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.setString(2, jogo.nome);
            comandoSQL.setString(3, jogo.genero);
            comandoSQL.setString(4, jogo.plataforma);
            comandoSQL.setString(5, jogo.lancamento);
            comandoSQL.executeUpdate();
            connection.commit();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Jogo getJogo(String nome){
        Jogo myJogo = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(selectName(nome));
            while(rs.next()){
                Jogo jogo = new Jogo(rs.getInt("id"));
                jogo.nome = rs.getString("nome");
                jogo.genero = rs.getString("genero");
                jogo.plataforma = rs.getString("plataforma");
                jogo.lancamento = rs.getString("lancamento");
                myJogo = jogo;
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return myJogo;
    }

    public boolean updateGame(Jogo jogo){
        try{
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kUpdateGame(jogo));
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();;
            return false;
        }
        return true;
    }

    public boolean deleteGame(String nome){
        try{
            Jogo jogo = getJogo(nome);
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kDeleteJogo(jogo));
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
