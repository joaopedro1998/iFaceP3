package Iface;
import java.util.*;

public class Profile {
	private String cellphone_number = "Vazio";
	private String relationship  = "Vazio";
	private String city  = "Vazio";
	private String job  = "Vazio";
	private String age  = "Vazio";
	private String description  = "Vazio";
	
	
	Scanner input = new Scanner(System.in);
	
	public Profile()
	{
		this.cellphone_number = "Vazio";
		this.relationship  = "Vazio";
		this.city  = "Vazio";
		this.job  = "Vazio";
		this.age  = "Vazio";
		this.description  = "Vazio";
	}
	
	public void allInformations()
	{
		System.out.println("Numero do celular: " + this.cellphone_number);
		System.out.println("Estado de relacionamento: " + this.relationship);
		System.out.println("Cidade: " + this.city);
		System.out.println("Trabalho: " + this.job);
		System.out.println("Idade: " + this.age);
		System.out.println("Descricao sobre voce: '"+ this.description + "'");
	}
	
	public void setCellPhoneNumber()
	{
		System.out.println("Digite o numero do seu celular: ");
		this.cellphone_number = input.next();
	}
	
	public String getCellPhoneNumber()
	{
		return cellphone_number;
	}
	
	public void setrelationship()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o seu estado atual de relacionamento: ");
		this.relationship = input.nextLine();
	}
	
	public String getrelationship()
	{
		return relationship;
	}
	
	public void setcity()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome da cidade que voce mora: " );
		this.city = input.nextLine();
	}
	
	public String getcity()
	{
		return city;
	}
	
	public void setjob()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome da sua profissao atual: ");
		this.job = input.nextLine();
	}
	
	public String getjob()
	{
		return job;
	}
	
	public void setAge()
	{
		System.out.println("Quantos anos voce tem?");
		this.age = input.next();
	}
	
	public String getAge()
	{
		return age;
	}
	
	public void setdescription()
	{
		System.out.println("Escreva uma descricao sobre voce: ");
		input = new Scanner(System.in);
		this.description = input.nextLine();
	}
	
	public String getdescription()
	{
		return description;
	}
	
	
}
