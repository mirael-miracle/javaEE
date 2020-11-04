package ejb3;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
/**
 * The persistent class for the PRIYOM database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findpriyomAll", query="SELECT c FROM priyom c"),
    @NamedQuery(name="findpriyomByJournal", 
        query="SELECT c FROM priyom c WHERE c.skarga = :skarga")
  })
public class Priyom3 implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String skarga;
  private String appendicit;
  private String datapr;

    public Priyom3() {
    }
  @Id
  @Column(name="ID", nullable=false)
  @SequenceGenerator(name="PRIYOM_ID_GENERATOR", sequenceName="PRIYOM_SEQ",allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIYOM_ID_GENERATOR")
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSkarga() {
    return this.skarga;
  }

  public void setSkarga(String skarga) {
    this.skarga = skarga;
  }
  public String getAppendicit() {
	    return this.appendicit;
	  }

	  public void setAppendicit(String appendicit) {
	    this.skarga = appendicit;
	  }
	  public String getDatapr() {
		    return this.datapr;
		  }

		  public void setDatapr(String datapr) {
		    this.skarga = datapr;
		  }

  //bi-directional many-to-one association to Edition
  @OneToMany(mappedBy="catalog", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
  @JoinTable(name="PRIYOMEDITIONS", 
    joinColumns=
        @JoinColumn(name="skargaId", referencedColumnName="ID"),
      inverseJoinColumns=
      @JoinColumn(name="diagnosId", referencedColumnName="ID")
      )

}