package musicians.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicians.springboot.model.Musician;
import musicians.springboot.repository.MusicianRepository;

@Service
public class MusicianServiceImpl implements MusicianService {

	@Autowired
	private MusicianRepository musicianRepository;

	@Override
	public List<Musician> getAllMusicians() {
		return musicianRepository.findAll();
	}

	@Override
	public Musician createMusician(Musician musician) {
		
		return musicianRepository.save(musician);
	}

	@Override
	public Musician getSingleMusician(Integer id) {
		Optional<Musician> musician=musicianRepository.findById(id);
		if(musician.isPresent()) {
			return musician.get();
		}
		else {
			throw new RuntimeException("Musician is not found");
		}
		
	}

	@Override
	public void deleteMusician(Integer id) {
		musicianRepository.deleteById(id);
		
	}

	
	
	
	
	
	
	
}
