package ma.fst.tkhzn.sdsi.entities;

        import java.io.Serializable;


        import javax.persistence.*;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Ressource_d implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String code;

    private int QteD;
    @ManyToOne
    @JoinColumn(name="id_user")
    private Utilisateur user;
    private int id_demande;
}
