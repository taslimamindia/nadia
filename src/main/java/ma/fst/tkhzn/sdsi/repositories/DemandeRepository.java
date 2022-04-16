package ma.fst.tkhzn.sdsi.repositories;

import ma.fst.tkhzn.sdsi.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public interface DemandeRepository extends JpaRepository<Demande,Integer> {


    @Query("select max(d.id) from Demande d ")
    public Integer getId();


    @Transactional
    @Modifying
    @Query("update Demande d set d.id_appel=:x where d.id=:y")
    public void setIdAppel(@Param("x")int id_appel,@Param("y")int id);

}
