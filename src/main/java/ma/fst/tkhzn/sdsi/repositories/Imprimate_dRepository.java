package ma.fst.tkhzn.sdsi.repositories;

import ma.fst.tkhzn.sdsi.entities.Imprimante_d;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Imprimate_dRepository extends JpaRepository<Imprimante_d,String> {
   /* @Query("select o.code from Imprimante_d o where o.resolution=:x and o.vitesse=:y  and o.marque=:t ")
    public String getCodeImp(@Param("x") Float resolution, @Param("y") Float vitesse, @Param("t") String marque);*/

}
