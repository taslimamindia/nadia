package ma.fst.tkhzn.sdsi.business;

import ma.fst.tkhzn.sdsi.entities.*;
import ma.fst.tkhzn.sdsi.repositories.*;
import ma.fst.tkhzn.sdsi.requests.DemandeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = {"api/demandeservice"})
@CrossOrigin
public class DemandeService {
    @Autowired
    EnseignantRepository enseignantrepository;
    @Autowired
    Ressource_dRepository ressource_dRepository;
    @Autowired
    Imprimate_dRepository imprimate_dRepository;
    @Autowired
    Ordinateur_dRepository ordinateur_dRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @RequestMapping(path = "/addDemande", method = RequestMethod.POST)
    public void addDemande(@RequestBody DemandeRequest demande){
        String code = UUID.randomUUID().toString();
        Utilisateur user=utilisateurRepository.findByLogin(demande.getLogin());
        if (demande.getType().equals("Imprimante")){

            Imprimante_d imprimante_d=new Imprimante_d(code,demande.getQteD(),user,0,demande.getImprimante_d().getMarque(),
                    demande.getImprimante_d().getResolution(),demande.getImprimante_d().getVitesse());
            System.out.println(imprimante_d.toString());
            imprimate_dRepository.save(imprimante_d);

        }else {
            Ordinateur_d ordinateur_d=new Ordinateur_d(code,demande.getQteD(),user,0,demande.getOrdinateur_d().getCpu(),demande.getOrdinateur_d().getDisque_d(),
                    demande.getOrdinateur_d().getEcran(),demande.getOrdinateur_d().getMarque(),demande.getOrdinateur_d().getRam());
            ordinateur_dRepository.save(ordinateur_d);
        }
    }
    @RequestMapping(path = "/listerDemande", method = RequestMethod.GET)
    public  List<Ressource_d> listerDemande(Principal user){
        System.out.println(user.getName());
        for (Ressource_d d:ressource_dRepository.findRess_d(user.getName()))
            System.out.println(d.toString());
        //return ressource_dRepository.findRess_d(user.getName());
        return  null;
    }

}
