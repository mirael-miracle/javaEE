package mysql.hospital;
import java.io.Serializable;

public class Doctor implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String name;
	 private String special;
	 
	 public Doctor(){ }
	 public Doctor(String name, String special) {
		 this.name = name;
		 this.special = special;
	 }
	 public Doctor(int id, String name, String special) {
		 this.id = id;
		 this.name = name;
		 this.special= special;
	 }
	 public int getId() {
	        return id;
	    }
	 public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSpecial() {
	        return special;
	    }
	 
	    public void setSpecial(String special) {
	        this.special= special;
	    }
}
