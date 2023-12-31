package Programa;

import java.util.ArrayList;
import java.util.Scanner;
import Utilitarios.Utils;
import javax.swing.JOptionPane;

import Programa.Pessoa;
import Programa.Conta;

public class AgenciaBancaria {

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +

				"|   Opção 1 - Criar conta   |" + "|   Opção 2 - Depositar     |" + "|   Opção 3 - Sacar         |"
				+ "|   Opção 4 - Transferir    |" + "|   Opção 5 - Listar        |" + "|   Opção 6 - Sair          |"));

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agência");
			System.exit(0); // para o sistema
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			System.exit(0); // para o sistema
			operacoes();
			break;
		}
	}

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

				
		pessoa.setName(JOptionPane.showInputDialog("Nome: "));
		
		if (pessoa.getName().equals(null) || (pessoa.getName().isEmpty())) {
			pessoa.setName(JOptionPane.showInputDialog("O nome não pode ser vazio. Insira seu nome: "));
			if (pessoa.getName().equals(null) || (pessoa.getName().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Nome invalido. Refaça a operação!");		
				operacoes();
			}
		}
		
		JOptionPane.showMessageDialog(null, "Nome cadastrado com sucesso. Preencha o próximo campo.");

		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		
		if (pessoa.getCpf().equals(null) || (pessoa.getCpf().isEmpty())) {
			pessoa.setCpf(JOptionPane.showInputDialog("O CPF não pode ser vazio. Insira um cpf: "));
			if (pessoa.getCpf().equals(null) || (pessoa.getCpf().isEmpty())) {
				JOptionPane.showMessageDialog(null, "CPF invalido. Refaça a operação!");		
				operacoes();
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "CPF cadastrado com sucesso. Preencha o próximo campo.");

		pessoa.setEmail(JOptionPane.showInputDialog("Email: "));
		
		if (Utils.isValidEmailAddressRegex(pessoa.getEmail()) != true) {
			JOptionPane.showMessageDialog(null, "Por favor, insira um email válido!");
			pessoa.setEmail(JOptionPane.showInputDialog("Email: "));
			if (Utils.isValidEmailAddressRegex(pessoa.getEmail()) != true) {
				JOptionPane.showMessageDialog(null, "Email inválido! Refaça a operação!");
				operacoes();
			}
		}
		
		JOptionPane.showMessageDialog(null, "Email cadastrado com sucesso. Preencha o próximo campo.");
		
		pessoa.setSenhaConta(JOptionPane.showInputDialog("Senha da conta: "));
		
		if (pessoa.getSenhaConta().equals(null) || (pessoa.getSenhaConta().isEmpty())) {
			pessoa.setSenhaConta(JOptionPane.showInputDialog("A senha não pode ser vazia. Insira uma senha: "));
			if (pessoa.getSenhaConta().equals(null) || (pessoa.getSenhaConta().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Senha invalida. Refaça a operação!");		
				operacoes();
			}
			
		}		
			
		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "Conta criada com sucesso.");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta contaa : contasBancarias) {
				if (contaa.getNumeroConta() == numeroConta) {
					conta = contaa;
				}
			}
		}
		return conta;
	}

	public static void depositar() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito: "));

		Conta conta = encontrarConta(numeroConta);
		
			
			if (conta != null) {
				
				String senha = JOptionPane.showInputDialog("Digite a senha da conta: ");
				if (senha.equals(conta.getClient().getSenhaConta())) {
					
				Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar: "));
				conta.depositar(valorDeposito);
			} else {
				
				JOptionPane.showMessageDialog(null, "Senha inválida!.");

	} 
		
	} else {
		JOptionPane.showMessageDialog(null, "Conta não encontrada.");
	}

		operacoes();

	}

	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque: "));
		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			
			String senha = JOptionPane.showInputDialog("Digite a senha da conta: ");
			
			if (senha.equals(conta.getClient().getSenhaConta())) {
			
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar: "));
			conta.sacar(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, "\"Senha inválida!");
		} 
	} else {
		JOptionPane.showMessageDialog(null, "Conta não encontrada.");
	} 
		operacoes();

	}

	public static void transferir() {
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente: "));

		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		
		if (contaRemetente != null) {
			
			String senha = JOptionPane.showInputDialog("Digite a senha da conta: ");
			
			if (senha.equals(contaRemetente.getClient().getSenhaConta())) {
			
				int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário: "));
	
				Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
	
				if (contaDestinatario != null) {
					Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));
	
					contaRemetente.transferencia(contaDestinatario, valor);

			} else {
				JOptionPane.showMessageDialog(null, "Conta para deposito não encontrada.");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Senha inválida!.");
		} 

		} else {
			JOptionPane.showMessageDialog(null, "Conta pra transferência invalida!."); 
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!.");
		}

		operacoes();
	}
}
