package Iface;
import java.util.*;

public class Community {
	Users owner;
	ArrayList<String> participant = new ArrayList<String>(); 
	private String communityName;
	private String description;
	
	public Community(Users owner, String name, String description)
	{
		this.owner = owner;
		this.communityName = name;
		this.description = description;
	}
	
	public void deleteParticipant(String name)
	{
		for(String p: participant)
			if(p.equals(name)) {
				participant.remove(p);
				return;
			}
		System.out.println("Participante nao encontrado!");
				
	}
	
	
	public void allParticipants()
	{
		for(String p: participant)
			System.out.println(p);
		if(participant.size() == 0)
		{
			System.out.println("Nao ha participantes cadastrados ainda nessa comunidade!");
		}
	}
	
	public void addParticipant(String participant)
	{
		this.participant.add(participant);
	}
	
	public String getName()
	{
		return this.communityName;
	}
	
}
