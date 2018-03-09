package Iface;
import java.util.*;

public class Menu {
	Scanner input = new Scanner(System.in);
	int confirmation;
	String login;
	String password;
	String name;
	
	public int begin()
	{
		System.out.println("===========================");
		System.out.println("[1]Fazer Login");
		System.out.println("[2]Cadastrar Usuário");
		System.out.println("[0]Sair do Iface");
		System.out.println("===========================");
		confirmation = input.nextInt();
		return confirmation;
	}
	
	public String login()
	{
		System.out.println("Digite seu Login:");
		return input.next();
	}
	
	public String password()
	{
		System.out.println("Digite sua Senha:");
		return input.next();
	}
	
	public String name()
	{
		input = new Scanner(System.in);
		System.out.println("Digite seu Nome:");
		return input.nextLine();
	}
	
	public int inside()
	{
		System.out.println("Escolha uma das seguintes acoes:");
		System.out.println("[1]Criar ou Editar atributos do perfil");
		System.out.println("[2]Adicionar um amigo");
		System.out.println("[3]Enviar uma mensagem");
		System.out.println("[4]Criar uma comunidade");
		System.out.println("[5]Gerenciar sua comunidade");
		System.out.println("[6]Entrar em uma comunidade");
		System.out.println("[7]Recuperar suas informacoes de conta");
		System.out.println("[8]Apagar sua conta");
		System.out.println("[9]Solicitacoes de amizade");
		System.out.println("[10]Ler mensagens nao visualizadas");
		System.out.println("[0]Sair da conta");
		return input.nextInt();
	}
	
	public String joinCommunity()
	{
		input = new Scanner(System.in);
		System.out.println("Qual comunidade voce gostaria de entrar?");
		System.out.println("Digite o nome dela:");
		return input.nextLine();
	}
	
	public String deleteParticipant()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome do participante que voce gostaria de excluir da sua comunidade:");
		return input.nextLine();
	}
	public int manageCommunity(String name)
	{
		System.out.println("Ola " + name);
		System.out.println("Qual das opcoes a seguir voce gostaria de escolher?");
		System.out.println("[1]Ver participantes da sua comunidade");
		System.out.println("[2]Deletar algum participante da sua comunidade");
		System.out.println("[0]Voltar ao menu do usuario");
		
		return input.nextInt();
	}
	
	public String addFriends()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome do amigo que você gostaria de adicionar:");
		return input.nextLine();
	}
	
	public String communityName()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome da comunidade que voce gostaria de criar: ");
		return input.nextLine();
	}
	
	public String communityDescription()
	{
		input = new Scanner(System.in);
		System.out.println("Escreva uma breve descricao sobre sua comunidade:");
		return input.nextLine();
	}
	
	public int editProfile()
	{
		System.out.println("Qual dos atributos voce gostaria de criar/editar?");
		System.out.println("[1]Numero do celular");
		System.out.println("[2]Status de relacionamento");
		System.out.println("[3]Cidade");
		System.out.println("[4]Trabalho");
		System.out.println("[5]Idade");
		System.out.println("[6]Descricao sobre voce");
	
		return input.nextInt();
	}
	
	public String messageReceiver()
	{
		input = new Scanner(System.in);
		System.out.println("Qual o nome do usuario que voce gostaria de mandar uma mensagem?");
		return input.nextLine();
	}
	
	public String sendMessage()
	{
		input = new Scanner(System.in);
		System.out.println("Digite a mensagem para ser enviada:");
		return input.nextLine();
	}
	
	public int recoverInformation()
	{
		System.out.println("Voce quer recuperar informacoes de que?");
		System.out.println("[1]Perfil");
		System.out.println("[2]Mensagens");
		System.out.println("[3]Amigos");
		System.out.println("[4]Comunidades");
		return input.nextInt();
			
	}
	
	
}
