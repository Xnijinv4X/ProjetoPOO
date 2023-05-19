package trabalhoPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Livro> livro = new ArrayList<>();
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		FicharioLivro fl = new FicharioLivro(livro);
		FicharioCliente fc = new FicharioCliente(cliente);
		Scanner sc = new Scanner(System.in);
		
		int op;
		int loop=0, loop2=0, loop3=0;
		
		while(loop==0) {// menu principal
			System.out.println("--==[MENU PRINCIPAL]==--");
			System.out.println("1 - Livros");
			System.out.println("2 - Clientes");
			System.out.println("3 - Emprestimo");
			op = sc.nextInt();
			
			switch(op) {
			
			case 1:// menu de livros
				loop2=0;
				while(loop2==0) {
					System.out.println("--==[MENU LIVROS]==--");
					System.out.println("1 - Cadastrar livro");
					System.out.println("2 - Relatório livros");
					System.out.println("3 - Consultar livro");
					System.out.println("4 - Alterar livro");
					System.out.println("5 - Excluir livro");
					System.out.println("6 - Voltar menu principal");
					op = sc.nextInt();
					switch(op) {
					case 1:
						fl.cadastro();
						break;
					case 2:
						if(!livro.isEmpty()){
						loop3=0;
							while(loop3==0) {
								System.out.println("--==[RELATÓRIOS]==--");
								System.out.println("1 - Livros cadastrados");
								System.out.println("2 - Livros disponiveis");
								System.out.println("3 - Livros indisponiveis");
								System.out.println("4 - Voltar menu livros");
								op = sc.nextInt();
								switch(op) {
								case 1:
									fl.relatorioLivrosCadastrados();
									break;
								case 2:
									fl.relatorioLivrosDisponiveis();
									break;
								case 3:
									fl.relatorioLivrosIndisponiveis();
									break;
								case 4:
									loop3=1;
									break;
								}
							}//========================================================== switch menu relatorios
						}else
							System.err.println("Sem livros cadastrados ainda");
						break;
					case 3:
						fl.consulta();
						break;
					case 4:
						fl.alteracao();
						break;
					case 5:
						fl.exclusao();
						break;
					case 6:
						loop2=1;
						break;
						default:
							System.err.println("Digite uma opção valida!");
							break;
					}//========================================================== switch menu livros
				}
				break;
			case 2:
				loop2=0;
				while(loop2==0) {
					System.out.println("--==[MENU CLIENTES]==--");
					System.out.println("1 - Cadastrar cliente");
					System.out.println("2 - Relatório cliente");
					System.out.println("3 - Alterar cliente");
					System.out.println("4 - Excluir cliente");
					System.out.println("5 - Consultar cliente");
					System.out.println("6 - Voltar menu principal");
					op = sc.nextInt();
					switch(op) {
					case 1:
						fc.cadastro();
						break;
					case 2:
					fc.relatorio();
						break;
					case 3:
						fc.alteracao();
						break;
					case 4:
						fc.exclusao();
						break;
					case 5:
						fc.consulta();
						break;
					case 6:
						loop2=1;
						break;
						default:
							System.err.println("Digite uma opção valida");
							break;
					}
				}
				break;
			case 3:
				break;
			case 4:
				break;
				default:
					System.err.println("Digite uma opção valida");
					break;
			}//========================================================== switch menu principal
		}//========================================================== while loop menu principal
	}//FINAL
}
