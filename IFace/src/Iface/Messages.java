package Iface;

public class Messages {
	private boolean receive; //false = message received, true = message send
	private String message;
	private String friendName;
	private boolean view;
	
	public Messages(boolean receive, String message, String friendName, boolean view)
	{
		this.receive = receive;
		this.message = message;
		this.friendName = friendName;
		this.view = view;
	}
	
	public void infoMessages()
	{
		if(!this.receive)
			System.out.print("Mensagem enviada por ");
		else
			System.out.print("Mensagem enviada para ");
		System.out.println(friendName + ":");
		System.out.println(message);
		System.out.println("==============================");
		
	}
	
	public String friendName()
	{
		return this.friendName;
	}
	
	public void readMessage()
	{
		System.out.println("Mensagem enviada por " + friendName + ":");
		System.out.println(message);
		this.view = true;
	}
	
	public boolean viewMessage()
	{
		return this.view;
	}
	
	public boolean sendMessage()
	{
		return receive;
	}
	
}
