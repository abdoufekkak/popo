package omg.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import omg.sid.entitie.Contact;

public interface
ContactRepository extends JpaRepository<Contact,Long>{

  @Query("select c from Contact c where c.nom like :x")
  public List<Contact> chercher(@Param("x") String mc);
}
