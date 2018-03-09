package Iface;
import java.util.*;

public class Users {
	
	Profile profile = new Profile();
	Friends friends = new Friends();
	ArrayList<Messages> messages = new ArrayList<Messages>();
	ArrayList<String> communities = new ArrayList<String>();
	
	boolean flag;
	
	private String ownCommunity = "Empty";
	private String login;
	private String password;
	private String name;
	
	public Users(String login, String password, String name)
	{
		this.login = login;
		this.password = password;
		this.name = name;
	}
	
	public void readMessages()
	{
		flag = true;
		for(Messages m: messages)
			if(m.viewMessage() == false)
			{
				m.readMessage();
				flag = false;
			}
		
		if(flag == true)
		{
			System.out.println("Ou voce nao tem mensagem, Ou voce ja visualizou todas!");
			System.out.println("Volte para o menu e recupere informacoes da sua conta para ver mensagens ja vistas");
		}
				
	}
	
	public void addCommunity(String name)
	{
		communities.add(name);
	}
	
	public String getOwnCommunity()
	{
		return this.ownCommunity;
	}
	
	public void setOwnCommunity(String name)
	{
		this.ownCommunity = name;
	}
	
	public void allFriends()
	{
		friends.allFriends();
	}
	
	public void allCommunities()
	{
		if(this.ownCommunity.equals("Empty"))
			System.out.println("Voce nao eh dono de nenhuma comunidade!");
		else
			System.out.println("Voce eh dono da comunidade " + ownCommunity);
		
		if(communities.size() == 0)
			System.out.println("Voce nao esta associado a nenhuma comunidade");
		else
		{
			System.out.println("Essas sao as comunidades que voce esta associado:");
			for(String c: communities)
				System.out.println(c);
		}
	}
	
	public void messagesFriendDelete(String name)
	{
		int i, size;
		size = messages.size();
		for(i = 0; i<size; ++i)
		{
			if(name.equals(messages.get(i).friendName()))
			{
				messages.remove(i);
				--i;
				--size;
			}
				
		}
	}
	
	public void allMessages()
	{
		if(messages.size() == 0) {
			System.out.println("Voce nunca mandou nem recebeu mensagens!");
			return;
		}
			
		for(Messages m : messages)
			m.infoMessages();
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getLogin()
	{
		return this.login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
}
