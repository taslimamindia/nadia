package ma.fst.tkhzn.sdsi.repositories;


import ma.fst.tkhzn.sdsi.entities.Ressource_d;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Ressource_dRepository extends JpaRepository<Ressource_d, String> {

    @Query("select R from Ressource_d R where R.user.login = :x")
    public List<Ressource_d> findRess_d(@Param("x")String login);


}