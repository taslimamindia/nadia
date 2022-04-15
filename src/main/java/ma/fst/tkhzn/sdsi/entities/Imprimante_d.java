package ma.fst.tkhzn.sdsi.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Imprimante_d extends Ressource_d implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marque;
    private float resolution;
    private float vitesse;

    public Imprimante_d(String code, int QteD, Utilisateur user, int id_demande, String marque, float resolution, float vitesse) {
        super(code, QteD, user, id_demande);
        this.marque = marque;
        this.resolution = resolution;
        this.vitesse = vitesse;
    }


    public String getMarque() {
        return marque;
    }

    public float getResolution() {
        return resolution;
    }

    public float getVitesse() {
        return vitesse;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }
}
