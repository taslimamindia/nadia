package ma.fst.tkhzn.sdsi.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.tkhzn.sdsi.entities.Imprimante_d;
import ma.fst.tkhzn.sdsi.entities.Ordinateur_d;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRess implements Serializable {
    private String personnel;
    private Long code;
    private String type;
    private OrdinateurR ord;
    private ImprimanteR imp;
}
