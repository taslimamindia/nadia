package ma.fst.tkhzn.sdsi.business;

import ma.fst.tkhzn.sdsi.entities.*;
import ma.fst.tkhzn.sdsi.repositories.*;
import ma.fst.tkhzn.sdsi.requests.DemandeRequest;
import ma.fst.tkhzn.sdsi.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(path = "/ajouterDemande", method = RequestMethod.POST)
    public void ajouterDemande(@RequestBody DemandeRequest demande,Principal login){
        System.out.println(demande);
    }

    @RequestMapping(path = "/addDemande", method = RequestMethod.POST)
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
    public List<UserRess> listerBesoins(Principal login){
        List<UserRess> userRess=new ArrayList<>();
        Utilisateur user=utilisateurRepository.findByLogin(login.getName());
        List<Utilisateur> users=utilisateurRepository.findBydepartement(user.getDepartement());
        for(Utilisateur usr:users){
            for (Imprimante_d imp:imprimate_dRepository.findRess_d(usr.getLogin())){
                ImprimanteR impr=new ImprimanteR(imp);
//                impr.setUser(new UtilisateurR(usr));
                userRess.add(new UserRess(imp.getUser().getNom() + " " + imp.getUser().getPrenom(), imp.getUser().getLogin(),imp.getCode(),"imprimante",null, impr));
            }
            for(Ordinateur_d ord:ordinateur_dRepository.findOrd_d(usr.getLogin())){
                OrdinateurR ordr=new OrdinateurR(ord);
//                ordr.setUser(new UtilisateurR(usr));
                userRess.add(new UserRess(ord.getUser().getNom() + " " + ord.getUser().getPrenom(), ord.getUser().getLogin(),ord.getCode(),"ordinateur",ordr,null));
            }
        }
        for(UserRess u: userRess) System.out.println(u);
        return userRess;
    }

   @RequestMapping(path = "/saveDemande", method = RequestMethod.POST)
    public  void  saveDemande(@RequestBody List<DemandeRequest> d, Principal usr) {
        ressource_dRepository.deleteRessource_d();
        demandeRepository.save(new Demande(utilisateurRepository.findByLogin(usr.getName())));
        int id = demandeRepository.getId();
        for (DemandeRequest de : d) {
            if(de.getType().equals("imprimante")){
                Imprimante_d imprimante_d=de.getImprimante_d();
                imprimante_d.setId_demande(id);
                de.setImprimante_d(imprimante_d);
                System.out.println(de);
                addDemande(de, usr);
            }else{
                Ordinateur_d ordinateur_d=de.getOrdinateur_d();
                ordinateur_d.setId_demande(id);
                de.setOrdinateur_d(ordinateur_d);
                System.out.println(de);
                addDemande(de, usr);
            }

        }
    }

    @RequestMapping(path = "/listerDemandes" ,method = RequestMethod.GET)
    public void listerDemandes(){
        List<Demande> demandes=demandeRepository.findAll();

        List<DemandeResponse> demandeResponses=new ArrayList<>();
        for (Demande d:demandes)
        {
            List<Ressource_d> ressource_ds=new ArrayList<>();
            ressource_ds=ressource_dRepository.listerRess_d(d.getId());
            demandeResponses.add(new DemandeResponse(ressource_ds,d.getUser_dem()));

        }
        System.out.println(demandeResponses);
    }
    @RequestMapping(path = "/addAppel", method = RequestMethod.GET)
    public void addAppel(){
        appelOffreRep.save(new AppelOffre());
        int id_Appel= appelOffreRep.getId();
        List<Demande> ds=demandeRepository.findAll();
        for (Demande d:ds){
            demandeRepository.setIdAppel(id_Appel,d.getId());
            }
        }

    }

