package Iface;

public class UsersPremium extends Users{

	private String ownCommunity = "Empty";
	
	
	public UsersPremium(String login, String password, String name) {
		super(login, password, name);
		// TODO Auto-generated constructor stub
	}
	
	public void community() {
		if(this.ownCommunity.equals("Empty"))
			System.out.println("Voce nao eh dono de nenhuma comunidade!");
		else
			System.out.println("Voce eh dono da comunidade " + ownCommunity);
	}
	
	
	public String getOwnCommunity()
	{
		return this.ownCommunity;
	}
	
	public void setOwnCommunity(String name)
	{
		this.ownCommunity = name;
	}

}
