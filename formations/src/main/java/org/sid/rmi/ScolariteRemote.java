package org.sid.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.sid.entities.Etudiant;
import org.sid.entities.Formation;

public interface ScolariteRemote extends Remote{
	
	public List<Etudiant> listEtudiants() throws RemoteException;
	public Etudiant getEtudiants(Long id) throws RemoteException;
	public Formation saveFormation(Formation f) throws RemoteException;

}
