
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client{
	public static void main(String args[]){
		Socket client;
		try{
                    // Criar novo cliente
			client = new Socket(host, 15000);
			if(client != null)
			{
				//Interacao com a interface 
                            // Nesse ponto, os dados do cliente devem ser obtidos, usando como base o ID digitado
                         
                            /*
                            A estrutura basica seraa a seguinte:
                            
                            if(botao apertado== recuperar){
                            
                                Requisicao req = new Requisicao(id, nome, email, score);
                            
                            }
                            if(botao apertado == cadastrar){
                                Requisicao req = new Requisicao(id, nome, email, score);
                            }
                            
                            */
                            
					
					
					
				//Envio de informacoes ao server
				ObjectOutputStream send = new ObjectOutputStream(client.getOutputStream);
				send.writeObject(req);
				
				//Aguardo de resposta
				ObjectOutputStream recv = new ObjectOutputStream(client.getInputStream);
				Resposta rep = (Resposta)recv.readObject();
				
				// Tratamento de respostas recebidas 
                                
                                
                                if(rep.getStatus() == Resposta.REGISTRADO){
					System.out.println("Registrado com sucesso" );
				}
                                else if(rep.getStatus() == Resposta.NAO_ENCONTRADO){
					System.out.println("Cliente nao encontrado" );
				}
                                else if(rep.getStatus() == Resposta.EXISTENTE){
					System.out.println("Cliente ja registrado" );
				}
				else
				{
					System.out.println("Erro");
				}
                                        
                                
                                // Fechar a conexao
				send.close();
				recv.close();
				client.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
