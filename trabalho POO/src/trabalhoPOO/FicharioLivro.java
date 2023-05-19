package trabalhoPOO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FicharioLivro {
	private ArrayList<Livro> livro;
	private Scanner sc = new Scanner(System.in);

	int cod, resp;
	
	public FicharioLivro(ArrayList<Livro> livro) {
		super();
		this.livro = livro;
	}
	public FicharioLivro() {
	}
	//=================================================================
	public void cadastro() {
		Livro liv = new Livro();
		
		System.out.println("--==[CADASTRO LIVRO]==--");
		
		liv.setStatus(true); // true = disponivel / false = indisponivel
		liv.setReservado(false);
		
		System.out.print("Nome autor: ");
		liv.setAutor(sc.nextLine());
		System.out.print("Nome titulo: ");
		liv.setTitulo(sc.nextLine());
		System.out.print("Tipo de gênero: ");
		liv.setGenero(sc.nextLine());
		System.out.print("Codigo ISBN: ");
		liv.setCodigo(sc.nextLine());
		System.out.print("Numéro edição: ");
		liv.setEdicao(sc.nextInt());
		sc.nextLine();
		
		livro.add(liv);
		System.out.println("Livro cadastrado com sucesso");
		
	}
	//=================================================================
	public void relatorioLivrosCadastrados() {
		if(!livro.isEmpty()) {
			System.out.println("--==[LIVROS CADASTRADOS]==--");
			Iterator<Livro> imp = livro.iterator();
			while(imp.hasNext()){
				Livro imprimir = imp.next();
				imprimirArray(imprimir);
			}
		}else
			System.out.println("Nenhum livro cadastrado");
	}
	//=================================================================
	public void relatorioLivrosDisponiveis() {
		if(!livro.isEmpty()) {
			Iterator<Livro> imp = livro.iterator();
			boolean verif = false;
			System.out.println("--==[LIVROS DISPONIVEIS PARA ALUGAR]==--");
			while(imp.hasNext()){
				Livro imprimir = imp.next();
				if(imprimir.isStatus()) {
					imprimirArray(imprimir);
					verif = true;
				}
				if(verif==false) {
					System.out.println("Nenhum livro disponivel");
				}
			}
		}else
			System.out.println("Nenhum livro cadastrado");
	}
	//=================================================================
	public void relatorioLivrosIndisponiveis() {
		if(!livro.isEmpty()) {
			Iterator<Livro> imp = livro.iterator();
			boolean verif = false;
			System.out.println("--==[LIVROS INDISPONIVEIS PARA ALUGAR]==--");
			while(imp.hasNext()) {
				Livro imprimir = imp.next();
				if(!imprimir.isStatus()) {
					imprimirArray(imprimir);
					verif = true;
				}
			}
			if(verif == false)
				System.out.println("Todos os livros disponiveis para alugar");
		}else
			System.out.println("Nenhum livro cadastrado");
	}
	//=================================================================
	public void alteracao() {
		boolean loop=true;
		if(!livro.isEmpty()) {
			while(loop) {
				System.out.println("--==[ALTERAÇÃO DE LIVRO]==--");
				imprimirIterator();
				System.out.println("Qual livro deseja alterar ? -1 para voltar");
				System.out.print("Código: ");
				cod = sc.nextInt();
				if(cod==-1) {
					sc.nextLine();
					break;
				}
				if(cod>=0 && cod<livro.size()) {
					Livro alt = livro.get(cod);
					imprimirArray(alt);
					System.out.println("1 - Alterar");
					System.out.println("2 - Cancelar alteração");
					System.out.println("3 - Escolher outro livro");
					resp = sc.nextInt();
					sc.hasNextLine();
					switch(resp) {
					case 1:
						
						sc.nextLine();
						System.out.print("Nome autor: ");
						alt.setAutor(sc.nextLine());
						System.out.print("Nome titulo: ");
						alt.setTitulo(sc.nextLine());
						System.out.print("Tipo de gênero: ");
						alt.setGenero(sc.nextLine());
						System.out.print("Codigo ISBN: ");
						alt.setCodigo(sc.nextLine());
						System.out.print("Numéro edição: ");
						alt.setEdicao(sc.nextInt());
						sc.nextLine();
						
						System.out.println("Livro alterado com sucesso");
						
						loop=false;
						break;
					case 2:
						System.out.println("Alteração cancelada!");
						loop=false;
						break;
					case 3:
						//meme
						break;
						default:
							System.err.println("Digite uma opção valida!");
							break;
					}
				}else
					System.err.println("Código invalido!! digite novamente");
			}
		}else
			System.err.println("Nenhum livro cadastrado");
	}
	//=================================================================
	public void exclusao() {
		boolean loop=true;
		if(!livro.isEmpty()) {
			while(loop) {
				System.out.println("--==[EXCLUSÃO DE LIVRO]==--");
				imprimirIterator();
				System.out.println("Qual livro deseja excluir? -1 cancelar exclusão");
				System.out.print("Código: ");
				cod = sc.nextInt();
				if(cod==-1) {
					sc.nextLine();
					break;
				}
				
				if(cod>=0 && cod<livro.size()) {
					Livro esc = livro.get(cod);
					imprimirArray(esc);
					System.out.println("1 - Excluir");
					System.out.println("2 - Cancelar exclusão");
					System.out.println("3 - Escolher outro livro");
					resp = sc.nextInt();
					
					switch(resp) {
					case 1:
						livro.remove(cod);
						System.out.println("Livro excluido com sucesso");
						loop=false;
						break;
					case 2:
						loop=false;
						break;
					case 3:
						//meme kkkkkkkkkkkk
						break;
						default:
							System.err.println("Digite uma opção valida");
							break;
					}
				}else
					System.err.println("Código invalido!! digite novamente");
			}
		}else
			System.err.println("Nenhum livro cadastrado");
	}
	//=================================================================
	public void consulta(){
		if(!livro.isEmpty()){
			boolean loop=true;
			while(loop){
				System.out.println("--==[CONSULTA DE LIVROS]==--");
				System.out.println("Livros cadastrados");
				imprimirIterator();
				System.out.println("Qual livro deseja consultar? -1 para voltar");
				System.out.print("Código: ");
				cod = sc.nextInt();
				if(cod==-1)
					break;

				if((cod>=0)&&(cod<livro.size())){
					System.out.println("Dados livro:");
					imprimirArray(livro.get(cod));
					loop=false;
				}else
					System.err.println("Código invalido, digite um codigo existente!");
			}
		}else
			System.out.println("Nenhum livro cadastrado");
	}

	//================================================METODOS DA CLASSE
	private void imprimirIterator() {
		int cont=0;
		Iterator<Livro> liv = livro.iterator();
		while(liv.hasNext()) {
			Livro alt = liv.next();
			System.out.println("[ Livro-: " + alt.getTitulo() + " Código-: " + cont + " ]");
			cont++;
		}
	}
	
	private void imprimirArray(Livro liv) {
		System.out.println("============================");
		System.out.println("[ autor-------: "  + liv.getAutor() + " ]");
		System.out.println("[ Titulo------: " + liv.getTitulo() + " ]");
		System.out.println("[ Gênero------: " + liv.getGenero() + " ]");
		System.out.println("[ Edição------: " + liv.getEdicao() + " ]");
		System.out.println("[ Codigo ISBN-: " + liv.getCodigo() + " ]");
		System.out.println("============================");
	}
}