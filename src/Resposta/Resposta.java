/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resposta;

public class Resposta implements java.io.Serializable{
	public static final int REGISTRADO = 0;
	public static final int NAO_ENCONTRADO = -1;
	public static final int EXISTENTE= -2;

        private int ID;
	private String nome;
	private String email;
        private int score;
        private int tipo;
        private int messageStatus;

	public Resposta(int ID, String nome, String email, int score, int tipo){
		this.ID=ID;
                this.nome=nome;
                this.email=email;
                this.score=score;
                this.tipo=tipo;

	}
	
	public void setID(int ID){
		this.ID = ID;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
        public void setEmail(String email){
		this.email= email;
	}
        public void setScore(int score){
		this.score = score;
	}
        public void setTipo(int tipo){
		this.tipo = tipo;
	}
        public void setMessageStatus(int messageStatus)
        {
            this.messageStatus = messageStatus;
        }

	public int getID(){
		return this.ID;
	}

	public String getNome(){
		return this.nome;
	}
        public String getEmail(){
		return this.email;
	}
        public int getScore(){
		return this.score;
	}
        public int getTipo(){
		return this.tipo;
	}
        public int getMessageStatus()
        {
            return messageStatus;
        }
}