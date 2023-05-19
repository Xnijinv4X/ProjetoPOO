package trabalhoPOO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FicharioCliente {
	private ArrayList<Cliente> cliente;
	private Scanner sc = new Scanner(System.in);
	int cod=0;
	int pos, resp;
	
	public FicharioCliente(ArrayList<Cliente> cliente) {
		super();
		this.cliente = cliente;
	}
	public FicharioCliente() {
	}
	//=================================================================
	public void cadastro() {
		System.out.println("--==[CADASTRO CLIENTE]==--");
		Cliente cli = new Cliente();
		
		System.out.print("digite nome do cliente: ");
		cli.setNome(sc.nextLine());
		System.out.print("Digite CPF do cliente: ");
		cli.setCpf(sc.nextLine());
		System.out.print("Digite o e-mail do cliente: ");
		cli.setEmail(sc.nextLine());
		
		cli.setCodigo(cod);
		cod++;
		
		cliente.add(cli);
		System.out.println("Cliente cadastrado com sucesso!");
	}
	//=================================================================
	public void relatorio() {
		System.out.println("--==[RELATÓRIO CLIENTES]==--");
		if(!cliente.isEmpty()){
			Iterator<Cliente> cli = cliente.iterator();
			while(cli.hasNext()){
				Cliente imp = cli.next();
				imprimirCliente(imp);
			}
		}else
			System.err.println("Sem clientes cadastrados");
		System.out.println("Relatório finalizado");
	}
	//=================================================================
	public void alteracao(){
		System.out.println("--==[ALTERAR CADASTRO]==--");
		if(!cliente.isEmpty()){
			boolean loop=true;
			while(loop){
				System.out.println("Lista dos clientes cadastrados:");
				imprimirIterator();

				System.out.println("Qual cliente deseja alterar? -1 para sair");
				System.out.print("Código: ");
				pos = sc.nextInt();
				sc.nextLine();
				if(pos==-1)
					loop=false;
					
				if((pos>=0)&&(pos<cliente.size())){
					imprimirCliente(cliente.get(pos));
					System.out.println("1 - Alterar cliente");
					System.out.println("2 - Cancelar alteração");
					System.out.println("3 - Escolher outro cliente");
					resp = sc.nextInt();
					sc.nextLine();
					switch(resp){
						case 1:
							System.out.println("--==[ALTERAR CLIENTE]==--");
							Cliente alt = cliente.get(pos);
							System.out.print("Novo nome cliente: ");
							alt.setNome(sc.nextLine());
							System.out.print("Novo CPF: ");
							alt.setCpf(sc.nextLine());
							System.out.print("Novo e-mail: ");
							alt.setEmail(sc.nextLine());

							System.out.println("Dados cliente alterado!");
							loop=false;
							break;
						case 2:
							System.out.println("Alteração cancelada");
							loop=false;
							break;
						case 3:
							//meme kk
							break;
							default:
								System.err.println("Digite uma opção valida!");
								break;
					}

				}else
					System.err.println("Digite um codigo valido");
			}
		}else
			System.err.println("Sem clientes cadastrados");
	}
	//=================================================================
	public void exclusao() {
		System.out.println("--==[EXCLUSÃO CLIENTE]==--");
		if(!cliente.isEmpty()){
				boolean loop=true;
				while(loop){
				System.out.println("Lista dos clientes cadastrados:");
				imprimirIterator();

				System.out.println("Qual cliente deseja alterar? -1 para sair");
				System.out.print("Código: ");
				pos = sc.nextInt();
				sc.nextLine();
				if(pos==-1)
					loop=false;

				if((pos>=0)&&(pos<cliente.size())){
					imprimirCliente(cliente.get(pos));
					System.out.println("1 - Excluir cliente");
					System.out.println("2 - Cancelar exclusão");
					System.out.println("3 - Escolher outro cliente");
					resp = sc.nextInt();
					switch(resp){
						case 1:
							cliente.remove(pos);
							System.out.println("Cliente removido");
							loop=false;
							break;
						case 2:
							loop=false;
							break;
						case 3:
							//memekk
							break;
							default:
								System.err.println("Digite uma opção valida");
								break;	
					}
				}else
					System.err.println("Digite um codigo valido");
			}
		}else
			System.err.println("Sem clientes cadastrados");
	}
	//=================================================================
	public void consulta(){
		if(!cliente.isEmpty()){
			boolean loop=true;
			while(loop){
				System.out.println("--==[CONSULTA CLIENTE]==--");
				System.out.println("Clientes para consultar:");
				imprimirIterator();
				System.out.println("Qual cliente deseja consultar? -1 para voltar");
				System.out.print("Código; ");
				cod = sc.nextInt();

				if(cod==-1)
					break;

				if((cod>=0)&&(cod<cliente.size())){
					System.out.println("Dados cliente:");
					imprimirCliente(cliente.get(cod));
					loop=false;
				}else
					System.err.println("Digite um código valido");
			}
		}else
			System.out.println("Sem clientes cadastrados");
	}
	//=================================================================METODOS DA CLASSE
	private void imprimirIterator(){
		Iterator<Cliente> cli = cliente.iterator();
		int cont=0;
		while(cli.hasNext()){
			Cliente imp = cli.next();
			System.out.println("[ Cliente-: " + imp.getNome() + " Código-: " + cont + " ]");
			cont++;
		}
	}

	private void imprimirCliente(Cliente c) {

		System.out.println("============================");
		System.out.println("[ Nome---: "    + c.getNome() + " ]");
		System.out.println("[ Email--: "   + c.getEmail() + " ]");
		System.out.println("[ CPF----: "     + c.getCpf() + " ]");
		System.out.println("[ Código-: "  + c.getCodigo() + " ]");
		System.out.println("============================");
		
	}
}
