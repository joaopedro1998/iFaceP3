package Iface;
import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		
		boolean working = true, alreadyExist = false;
		MenuStatus flag = MenuStatus.Begin;
		Menu menu = new Menu();
		ArrayList<Users> users = new ArrayList<Users>();
		String login,password,name,message;
		int optionChoosed, accountLogged = -1, messageReceiver = -1, size;
		ArrayList<Community> community = new ArrayList<Community>();
		
		while(working)
		{
			switch (flag) {
				case Begin :
					optionChoosed = menu.begin();
					if(optionChoosed == 1)
						flag = MenuStatus.Login;
					else if(optionChoosed == 2)
						flag = MenuStatus.Register;
					else
						flag = MenuStatus.LeaveIface;
					break;
				case Login:
					login = menu.login();
					password = menu.password();
					for(Users user : users)
					{
						++accountLogged;
						if(user.getLogin().equals(login))
							if(user.getPassword().equals(password))
							{
								System.out.println("Login efetuado");
								flag = MenuStatus.Inside;
								break;
							}
					}
					if(flag != MenuStatus.Inside)
					{
						accountLogged = -1;
						System.out.println("Login ou Senha incorreto!");
						flag = MenuStatus.Begin;
					}				
					break;
				case Register:
					login = menu.login();
					password = menu.password();
					name = menu.name();
					alreadyExist = false;
					for(Users user : users)
						if(user.getLogin().equals(login))
						{
							alreadyExist = true;
							System.out.println("Ja existe usuario com esse login, tente novamente!");
							break;
						}
					if(alreadyExist == false)
					{
						users.add(new Users(login,password,name));
						flag = MenuStatus.Begin;
					}				
					break;
				case Inside:
					optionChoosed = menu.inside();
					if(optionChoosed == 1)
						flag = MenuStatus.EditProfile;
					else if(optionChoosed == 2)
						flag = MenuStatus.AddFriends;
					else if(optionChoosed == 3)
						flag = MenuStatus.SendMessage;
					else if(optionChoosed == 4)
						flag = MenuStatus.CreateCommunity;
					else if(optionChoosed == 5)
						flag = MenuStatus.ManageCommunity;
					else if(optionChoosed == 6)
						flag = MenuStatus.JoinCommunity;
					else if(optionChoosed == 7)
						flag = MenuStatus.RecoverInformations;
					else if(optionChoosed == 8)
						flag = MenuStatus.DeleteAccount;
					else if(optionChoosed == 9)
						flag = MenuStatus.FriendRequest;
					else if(optionChoosed == 10)
						flag = MenuStatus.ReadMessages;
					else if(optionChoosed == 0)
						flag = MenuStatus.LeaveAccount;
					break;
				case AddFriends:
					name = menu.addFriends();
					for(Users u: users)
						if(name.equals(u.getName()))
						{
							u.friends.addRequest(users.get(accountLogged).getName());
							flag = MenuStatus.Inside;
							System.out.println("Aguardando aceitacao de amizade por parte do seu amigo");
							break;
						}							
					if(flag != MenuStatus.Inside)
						System.out.println("Amigo nao encontrado!");
					flag = MenuStatus.Inside;
					break;
				case ManageCommunity:
					name = users.get(accountLogged).getOwnCommunity();
					if(name.equals("Empty"))
					{
						System.out.println("Voce nao tem comunidade cadastrada em seu nome!");
						flag = MenuStatus.Inside;
					}
					else
					{
						for(Community c: community)
						{
							if(c.getName().equals(name))
							{
								optionChoosed = menu.manageCommunity(users.get(accountLogged).getName());
								if(optionChoosed == 1)
									c.allParticipants();
								else if(optionChoosed == 2)
									c.deleteParticipant(menu.deleteParticipant());
								else if(optionChoosed == 0)
									flag = MenuStatus.Inside;
									
								break;
							}
						}
							
					}
					
					break;
				case ReadMessages:
					users.get(accountLogged).readMessages();
					flag = MenuStatus.Inside;
					break;
				case JoinCommunity:
					name = menu.joinCommunity();
					for(Community c: community)
					{
						if(c.getName().equals(name))
						{
							users.get(accountLogged).addCommunity(name);
							c.addParticipant(users.get(accountLogged).getName());
							flag = MenuStatus.Inside;
							break;
						}
					}
					if(flag != MenuStatus.Inside)
						System.out.println("Nao foi possivel encontrar comunidade com este nome!");
					flag = MenuStatus.Inside;
					break;
				case CreateCommunity:
					name = menu.communityName();
					for(Community c : community)
					{
						if(c.getName().equals(name))
						{
							flag = MenuStatus.Inside;
							System.out.println("Ja existe uma comunidade com esse nome");
							System.out.println("Voce sera redirecionado para o menu");
							break;
						}
							
					}
					if(flag != MenuStatus.Inside)
					{
						community.add(new Community(users.get(accountLogged),name,menu.communityDescription()));
						users.get(accountLogged).setOwnCommunity(name);
						flag = MenuStatus.Inside;
					}
					break;
				case EditProfile:
					optionChoosed = menu.editProfile();
					if(optionChoosed == 1)
						users.get(accountLogged).profile.setCellPhoneNumber();
					else if(optionChoosed == 2)
						users.get(accountLogged).profile.setrelationship();
					else if(optionChoosed == 3)
						users.get(accountLogged).profile.setcity();
					else if(optionChoosed == 4)
						users.get(accountLogged).profile.setjob();
					else if(optionChoosed == 5)
						users.get(accountLogged).profile.setAge();
					else if(optionChoosed == 6)
						users.get(accountLogged).profile.setdescription();
					flag = MenuStatus.Inside;
					break;
				case SendMessage:
					messageReceiver = -1;
					name = menu.messageReceiver();
					for(Users user : users)
					{
						++messageReceiver;
						if(user.getName().equals(name))
						{
							flag = MenuStatus.Inside;
							break;	
						}
					}
					if(flag == MenuStatus.Inside)
					{
						message = menu.sendMessage();
						users.get(accountLogged).messages.add(new Messages(true, message, users.get(messageReceiver).getName(), true));
						users.get(messageReceiver).messages.add(new Messages(false, message, users.get(accountLogged).getName(), false));
					}
					else
					{
						System.out.println("Usuario nao encontrado! Voce sera redirecionado para o menu!");
						flag = MenuStatus.Inside;
					}
					break;
				case DeleteAccount:
					name = users.get(accountLogged).getName();
					for(Users user : users)
						user.messagesFriendDelete(name);
					users.remove(accountLogged);
					flag = MenuStatus.Begin;
					break;
				case RecoverInformations:
					optionChoosed = menu.recoverInformation();
					if(optionChoosed == 1)
					{
						System.out.println("Nome: "+ users.get(accountLogged).getName());
						users.get(accountLogged).profile.allInformations();
					}
					else if(optionChoosed == 2)
						users.get(accountLogged).allMessages();
					else if(optionChoosed == 3)
						users.get(accountLogged).allFriends();
					else if(optionChoosed == 4)
						users.get(accountLogged).allCommunities();
					flag = MenuStatus.Inside;	
					break;
				case LeaveAccount:
					flag = MenuStatus.Begin;
					accountLogged = -1;
					break;
				case LeaveIface:
					working = false;
					break;
				case FriendRequest:
					size = users.get(accountLogged).friends.requestsSize();
					if(size == 0)
						System.out.println("Voce nao possui solicitacao de amizade!");
					while(size> 0)
					{
						name = users.get(accountLogged).friends.verifyRequests();
						if(!name.equals("Empty"))
							for(Users u: users)
								if(u.getName().equals(name))
									u.friends.addFriends(users.get(accountLogged).getName());
						--size;
					}
					flag = MenuStatus.Inside;
					break;
				default:
					flag = MenuStatus.Inside;
			}
			
		}
	}

	public enum MenuStatus {
	    Begin,
	    Login,
	    Register,
	    Inside,
	    AddFriends,
	    EditProfile,
	    CreateCommunity,
	    SendMessage,
	    DeleteAccount,
	    LeaveAccount,
	    LeaveIface,
	    ManageCommunity,
	    JoinCommunity,
	    RecoverInformations,
	    FriendRequest,
	    ReadMessages;
	}

	
	
}
