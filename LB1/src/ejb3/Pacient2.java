package ejb3;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@NamedQueries( { @NamedQuery(name = "findPacientAll",
        query = "SELECT e FROM Pacient e")
,
@NamedQuery(name = "findPacientByPacient", query = "SELECT e from Pacient e WHERE e.pacient = :pacient")
} )
public class Pacient2 implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;
  private String skarga;
  private Priyom3 priyom;

    public Pacient2() {
    }

  @Id
  @Column(name="ID", nullable=false)
  @SequenceGenerator(name="PACIENT_ID_GENERATOR", sequenceName="PACIENT_SEQ",allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENT_ID_GENERATOR")
  public int getId() {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "PacientPriyom",
               joinColumns = { @JoinColumn(name = "pacientId",referencedColumnName = "ID")
                } ,
inverseJoinColumns = { @JoinColumn(name = "priyomId", referencedColumnName ="ID")})
  public Priyom3 getPriyom() {
    return this.priyom;
  }
  public void setPriyom(Priyom3 priyom) {
    this.priyom = priyom;
  }
  
  //bi-directional many-to-one association to Section
  @OneToMany(mappedBy="pacient", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
  @JoinTable(name = "PacientSections",
               joinColumns = { @JoinColumn(name = "pacientId",
                                           referencedColumnName = "ID")
                } ,
        inverseJoinColumns = { @JoinColumn(name = "sectionId", referencedColumnName =
                                           "ID")
                } )

  public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSkarga() {
        return skarga;
    }
    public void setSkarga(String skarga) {
        this.skarga = skarga;
    }
}