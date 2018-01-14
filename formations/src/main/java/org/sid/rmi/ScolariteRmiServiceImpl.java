package org.sid.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.sid.dao.EtudiantRepository;
import org.sid.dao.FormationRepository;
import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ScolariteRmiServiceImpl implements ScolariteRemote{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Override
	public List<Etudiant> listEtudiants() throws RemoteException {
	    return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getEtudiants(Long id) throws RemoteException {
		return etudiantRepository.findOne(id);
	}

	@Override
	public Formation saveFormation(Formation f) throws RemoteException {
		return formationRepository.save(f);
	}

}
