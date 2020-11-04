package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table
@NamedQuery(query = "Select * from priyom  where id = :id", 
	name = "find priyom by id")
public class PriyomJPQL {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 	
	private int id;
	private String name;
	private String skarga;
	private String diagnos;
	private String datapr;
	public PriyomJPQL(int id, String name, String skarga, String diagnos, String datapr) 
	{
		super( );
		this.id = id;
		this.name = name;
		this.skarga = skarga;
		this.diagnos = diagnos;
		this.datapr = datapr;
	}
	public PriyomJPQL( ) 
	{
		super();
	}
	
	public int getId( ) 
	{
		return id;
	}
	public void setId(int id)  
	{
		this.id = id;
	}
	
	public String getName( ) 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSkarga( ) 
	{
		return skarga;
	}
	public void setSkarga(String skarga) 
	{
		this.skarga = skarga;
	}
	
	public String getDiagnos( ) 
	{
		return diagnos;
	}
	public void setDiagnos(String diagnos) 
	{
		this.diagnos = diagnos;
	}
	@Override
	public String toString() {
		return "Priyom [id=" + id + ", name=" + name + ", skarga="
				+ skarga + ", diagnos=" + diagnos +", datapr=" + datapr+ "]";
	}
}
