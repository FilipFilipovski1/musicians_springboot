package musicians.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import musicians.springboot.model.Musician;

@Repository
public interface MusicianRepository extends JpaRepository<Musician,Integer>{

}
