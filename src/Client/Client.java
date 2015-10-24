
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Resposta.Resposta;
import Requisicao.Requisicao;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client {

    Socket client;

    Client(String host, int porta) throws IOException {
        //Socket client;
            // Criar novo cliente
            client = new Socket(host, porta);
            client.setKeepAlive(true); //deixa o cliente ativo
    }

    public Resposta sendReceive(Requisicao req) throws IOException, ClassNotFoundException 
    {
        ObjectOutputStream send = new ObjectOutputStream(client.getOutputStream());
        send.writeObject(req);

        //Aguardo de resposta
        ObjectInputStream recv = new ObjectInputStream(client.getInputStream());
        Resposta rep = (Resposta) recv.readObject();
        
        // Fechar a conexao
                send.close();
                recv.close();
                close();
        return rep;   
    }

    public Resposta sendReq(int id) throws IOException, ClassNotFoundException 
    {
        return sendReceive(new Requisicao(id));
    }
    
    public Resposta sendCadastro(int ID, String nome, String email, int score, int tipo) throws IOException, ClassNotFoundException
    {
        return sendReceive(new Requisicao(ID, nome, email, score, tipo));
    }

    public void close() throws IOException
    {
        client.close();
    }
}
