package org.sid.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.sid.dao.EtudiantRepository;
import org.sid.dao.FormationRepository;
import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class ScolariteSoapService {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@WebMethod(operationName="listEtudiants")
	public List<Etudiant> list(){
		return etudiantRepository.findAll();
	}
	
	@WebMethod
	public Etudiant getOne(@WebParam(name="id") Long id){
		 return etudiantRepository.findOne(id);
	 }
	 
	@WebMethod
	public Formation save(@WebParam(name="formation")Formation f){
		 return formationRepository.save(f);
	 }
	 
	 

}
