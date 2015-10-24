/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requisicao;

/**
 *
 * @author Fernanda Miyuki
 */
public class Requisicao implements java.io.Serializable{
	private String nome;
	private String email;
	private int score;
        private int ID;
        private int tipo;
	
	public Requisicao(int ID, String nome, String email, int score, int tipo){
		this.ID=ID;
                this.nome=nome;
                this.email=email;
                this.score=score;
                this.tipo= tipo;

	}
        
        public Requisicao(int ID)
        {
            this.ID = ID;
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
        public void setTipo(int tipo){
		this.tipo = tipo;
	}

	public int getTipo(){
		return this.tipo;
	}

}
