package ma.fst.tkhzn.sdsi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demande {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur user_dem;
    private Date date;
}
