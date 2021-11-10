package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.repository.ContratRepository;



@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;

	// TODO Logger à ajouter  
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	

	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method retriveAllContrats");
			contrats = (List<Contrat>) contratRepository.findAll(); 
			l.info("Contrats");
			l.debug("Connsxion Bd");


			for (Contrat contrat : contrats) {
				l.info("Contrat"+contrat.getTypeContrat());
			} 
			l.info("out with succes AllContrats");

		}catch (Exception e) {
l.error("out of method with erro"+e);		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		l.info("In Method addContrat");
		Contrat c_saved = contratRepository.save(c); 
		l.info("out with succes addContrat");
		return c_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat  c) { 
		l.info("In Method updateContrat");	
		Contrat c_saved = contratRepository.save(c); 
		l.info("out with succes updateContrat");	
		return c_saved; 
	}

	@Override
	public void deleteContrat(String id) {
		l.info("In Method deleteContrat");	
		contratRepository.deleteById(Integer.parseInt(id));
		l.info("out with succes deleteContrat");	

	}

	@Override
	public Contrat retrieveContrat(String id) {
		l.info("In Method retrieveContrat");	
		Contrat c =  contratRepository.findById(Integer.parseInt(id)).get(); 
		l.info("out with succes retrieveContrat");	
		return c; 
	}

}
