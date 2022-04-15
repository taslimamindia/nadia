package ma.fst.tkhzn.sdsi.repositories;

import ma.fst.tkhzn.sdsi.entities.Ordinateur_d;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ordinateur_dRepository extends JpaRepository<Ordinateur_d,String> {

    @Query("select o.code from Ordinateur_d o where o.cpu=:x and o.disque_d=:y and o.ecran=:z and o.marque=:t and o.ram=:u")
    public String getCodeOrd(@Param("x") String cpu,@Param("y") Integer disque_d,@Param("z") Float ecran,@Param("t") String marque,@Param("u") Integer ram);
}
