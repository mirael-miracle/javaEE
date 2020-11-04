package ejb3;

import java.io.Serializable;
import javax.persistence.*;
/**
 * The persistent class for the DOCTOR database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findDoctorAll", query="SELECT a FROM Doctor a"),
    @NamedQuery(
      name="findDoctorByName", query="SELECT a from Doctor a WHERE a.name = :name")
  })
public class Doctor1 implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;
  private String special;

    public Doctor1() {
    }

  @Id
  @Column(name="ID", nullable=false)
  @SequenceGenerator(name="DOCTOR_ID_GENERATOR", sequenceName="DOCTOR_SEQ",allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCTOR_ID_GENERATOR")
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getSpecial() {
	    return this.special;
	  }

	  public void setSpecial(String special) {
	    this.special = special;
	  }

  @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "DoctorSection",
        joinColumns = {  
            @JoinColumn(name="doctorId", referencedColumnName="ID")},   
            inverseJoinColumns = { @JoinColumn(name="sectionId", referencedColumnName="ID")}
)
  
}