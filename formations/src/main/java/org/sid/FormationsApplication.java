package org.sid;

import java.util.stream.Stream;

import org.sid.dao.EtudiantRepository;
import org.sid.dao.FormationRepository;
import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationsApplication implements CommandLineRunner{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormationsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Stream.of("Java", "JEE", "Oracle").forEach(nF -> {
			Formation f = new Formation();
			f.setNom(nF);
			f.setDuree(30);
			formationRepository.save(f);			
		});
		
		etudiantRepository.save(
				new Etudiant(null, "Salamou", "Slim", new Formation(1L, null, 0, null)));
		etudiantRepository.save(
				new Etudiant(null, "Bihi", "Ali", new Formation(1L, null, 0, null)));
		etudiantRepository.save(
				new Etudiant(null, "Ana", "Lili", new Formation(2L, null, 0, null)));
		etudiantRepository.save(
				new Etudiant(null, "Howa", "Fifi", new Formation(3L, null, 0, null)));
		
		formationRepository.findAll().forEach(f -> {
		System.out.println(f.getNom());	
		
		});
		
	}
}
