package ma.fst.tkhzn.sdsi.repositories;

import ma.fst.tkhzn.sdsi.entities.Imprimante_d;
import ma.fst.tkhzn.sdsi.entities.Ressource_d;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Imprimate_dRepository extends JpaRepository<Imprimante_d,String> {
   /* @Query("select o.code from Imprimante_d o where o.resolution=:x and o.vitesse=:y  and o.marque=:t ")
    public String getCodeImp(@Param("x") Float resolution, @Param("y") Float vitesse, @Param("t") String marque);*/
   @Query("select R from Imprimante_d R where R.user.login = :x")
   public List<Imprimante_d> findRess_d(@Param("x")String login);

   @Query("select R from Imprimante_d R where R.code = :x")
   public Imprimante_d findByCode(@Param("x")Long code);
}
