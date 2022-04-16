package ma.fst.tkhzn.sdsi.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.fst.tkhzn.sdsi.entities.*;
import ma.fst.tkhzn.sdsi.repositories.*;
import ma.fst.tkhzn.sdsi.requests.DemandeRequest;
import ma.fst.tkhzn.sdsi.responses.DemandeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = {"api/demandeservice"})
@CrossOrigin

public class DemandeService {
    @Autowired
    AppelOffreRep appelOffreRep;
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
    @Autowired
    DemandeRepository demandeRepository;
    @RequestMapping(path = "/addDemande", method = RequestMethod.POST)
    /*public void addDemande(@RequestBody DemandeRequest demande,Principal login){
        Utilisateur user=utilisateurRepository.findByLogin(login.getName());
        if (demande.getType().equals("Imprimante")){

            Imprimante_d imprimante_d=new Imprimante_d(demande.getQteD(),user,demande.getId_demande(),demande.getImprimante_d().getMarque(),
                    demande.getImprimante_d().getResolution(),demande.getImprimante_d().getVitesse());
            System.out.println(imprimante_d.toString());
            imprimate_dRepository.save(imprimante_d);

        }else {
            Ordinateur_d ordinateur_d=new Ordinateur_d(demande.getQteD(),user,demande.getId_demande(),demande.getOrdinateur_d().getCpu(),demande.getOrdinateur_d().getDisque_d(),
                    demande.getOrdinateur_d().getEcran(),demande.getOrdinateur_d().getMarque(),demande.getOrdinateur_d().getRam());
            ordinateur_dRepository.save(ordinateur_d);
        }
    }*/

    public void addDemande(@RequestBody DemandeRequest demande,Principal login){
        System.err.println(demande);
        Utilisateur user = utilisateurRepository.findByLogin(login.getName());
        if (demande.getType().equals("imprimante")){
            Imprimante_d imp = demande.getImprimante_d();
            imp.setUser(user);
            imprimate_dRepository.save(imp);
        }
        else {
            Ordinateur_d ord = demande.getOrdinateur_d();
            ord.setUser(user);
            ordinateur_dRepository.save(ord);
        }
    }
    @RequestMapping(path = "/listerBesoins", method = RequestMethod.GET)
    public  List<Ressource_d> listerBesoins(Principal user){
        DemandeResponse demandeResponse =new DemandeResponse();
        demandeResponse.setRessource_ds(ressource_dRepository.findRess_d(user.getName()));
        return demandeResponse.getRessource_ds();
    }

    /*@RequestMapping(path = "/saveDemande", method = RequestMethod.POST)
    public  void  saveDemande(@RequestBody List<DemandeRequest> d, Principal usr) {

        ressource_dRepository.deleteRessource_d();
        demandeRepository.save(new Demande(utilisateurRepository.findByLogin(usr.getName())));
        int id = demandeRepository.getId();
        for (DemandeRequest de : d) {
            de.setId_demande(id);
            System.out.println(de);
            addDemande(de, usr);
        }
    }
    @RequestMapping(path = "/listerDemandes" ,method = RequestMethod.GET)
    public List<DemandeResponse> listerDemandes(){
        List<Demande> demandes=demandeRepository.findAll();

        List<DemandeResponse> demandeResponses=new ArrayList<>();
        for (Demande d:demandes)
        {
            List<Ressource_d> ressource_ds=new ArrayList<>();
            ressource_ds=ressource_dRepository.listerRess_d(d.getId());

            demandeResponses.add(new DemandeResponse(ressource_ds,d.getUser_dem()));

        }
        System.out.println(demandeResponses);
        return  demandeResponses;
    }

    @RequestMapping(path = "/addAppel", method = RequestMethod.POST)
    public void addAppel(@RequestBody List<DemandeResponse> demandeResponses){
        for (DemandeResponse dr:demandeResponses){
            for(Ressource_d r:dr.getRessource_ds()){
                appelOffreRep.save(new AppelOffre(r.getCode(),r.getQteD()));
            }
        }

    }*/
}
