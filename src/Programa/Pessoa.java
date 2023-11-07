package Programa;

import java.util.Date;

import Utilitarios.Utils;

public class Pessoa {

    private static int counter = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
    private String email;
    private String senhaConta;
    private Date accountCreationDate;

    public Pessoa() { }

    public Pessoa(String name, String cpf, String email, String senhaConta) {
        this.numeroPessoa = Pessoa.counter;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.senhaConta = senhaConta;
        this.accountCreationDate = new Date();
        Pessoa.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenhaConta() {
        return senhaConta;
    }
    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }
    
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nEmail: " + this.getEmail() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }


}
