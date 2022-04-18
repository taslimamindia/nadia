package ma.fst.tkhzn.sdsi.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.tkhzn.sdsi.entities.Imprimante_d;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImprimanteR extends Ressource_DR implements Serializable {
    private String marque;
    private float resolution;
    private float vitesse;

    public ImprimanteR(Imprimante_d imp) {
        super(imp.getCode(),imp.getQteD(),imp.getId_demande());
        this.marque = imp.getMarque();
        this.resolution = imp.getResolution();
        this.vitesse = imp.getVitesse();
    }
}
