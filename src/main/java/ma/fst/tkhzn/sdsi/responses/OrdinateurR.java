package ma.fst.tkhzn.sdsi.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.tkhzn.sdsi.entities.Ordinateur_d;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdinateurR extends Ressource_DR implements Serializable {
    private String cpu;
    private int disque_d;
    private float ecran;
    private String marque;
    private int ram;

    public OrdinateurR(Long code, UtilisateurR user, int qteD, int id_demande, String cpu, int disque_d, float ecran, String marque, int ram) {
        super(code, user, qteD, id_demande);
        this.cpu = cpu;
        this.disque_d = disque_d;
        this.ecran = ecran;
        this.marque = marque;
        this.ram = ram;
    }
    public OrdinateurR(Ordinateur_d ord) {
        super(ord.getCode(),ord.getQteD(),ord.getId_demande());
        this.cpu = ord.getCpu();
        this.disque_d = ord.getDisque_d();
        this.ecran = ord.getEcran();
        this.marque = ord.getMarque();
        this.ram = ord.getRam();
    }
}
