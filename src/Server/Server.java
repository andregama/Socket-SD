/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Fernanda Miyuki
 */

import java.io.*;
import java.net.*;

public class Server{
	public static void main (String args[]){
		ServerSocket server;
		Socket client;
		try{
			// Criando um novo socket
			server = new ServerSocket(15000);
			while(true)
			{
                            
				client = server.accept(); // Cliente aceita a conexao
				System.out.println("Aceite de conexão");// Texto de aceite
				System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress()); // Texto que mostra o endereco do cliente conectado
				/*
                                O stream é um objeto de transmissão de dados, onde um fluxo de dados serial é feito através de uma origem e de um destino. 
                                O FileOutputStream é um fluxo de arquivo que permite a gravação em disco.  Já o FileInputStream é justamente o contrário, permitindo a leitura de um arquivo em disco.
                                
                                */
                                ObjectInputStream recv = new ObjectInputStream(client.getInputStream());
				Requisicao requisicao = (Requisicao) recv.readObject();
				int result,status;
				//Trata a operacao recebida
				// Pode ser usado um switch case
				Resposta resposta = new Resposta(result, status);
				
				// Envia a resposta para o cliente
				ObjectOutputStream send = new ObjectOutputStream(client.getOutputStream());
				send.writeObject(resposta);
				
				recv.close();
				send.close();
				client.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
