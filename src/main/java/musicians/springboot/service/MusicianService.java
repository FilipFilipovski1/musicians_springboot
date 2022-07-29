package musicians.springboot.service;

import java.util.List;

import musicians.springboot.model.Musician;

public interface MusicianService {
	
	List<Musician> getAllMusicians();

	Musician createMusician(Musician musician);
	
	Musician getSingleMusician(Integer id);
	
	void deleteMusician(Integer id);
	

}
