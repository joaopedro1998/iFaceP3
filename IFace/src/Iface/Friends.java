package Iface;
import java.util.*;

public class Friends {
	ArrayList<String> friends = new ArrayList<String>();
	ArrayList<String> requests = new ArrayList<String>();
	
	int confirmation;
	String name;
	Scanner input = new Scanner(System.in);
	
	public void addFriends(String name)
	{
		this.friends.add(name);
	}
	
	public void addRequest(String name)
	{
		requests.add(name);
	}
	
	public int requestsSize()
	{
		return requests.size();
	}
	
	public String verifyRequests()
	{
		if(requests.size() == 0)
		{
			System.out.println("Voce nao tem nenhuma solicitacao de amizade!");
			return "Empty";
		}
		
		name = requests.get(0);
		requests.remove(0);
		
		System.out.println("Voce gostaria de adicionar " + name + "?");
		System.out.println("[1]Sim");
		System.out.println("[2]Nao");
		confirmation = input.nextInt();
		
		if(confirmation == 1)
		{
			this.friends.add(name);
			return name; 
		}		
		
		return "Empty";	
		
	}
	
	public void allFriends()
	{
		for(String f: friends)
		{
			System.out.println(f);
		}
	}
	
}
