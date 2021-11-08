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

	// TODO Logger à ajouter  (ok)
	private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);
	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode (ok)
			L.info("In Method retriveAllContrats :" );
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				// TODO Log à ajouter pour affiher chaque Contrat dans les logs   (ok)
			    L.debug("contrat :" + contrat.getTypeContrat());
			   // int i =1/0;
			} 
			// TODO Log à ajouter à la fin de la méthode (ok)
			L.error("Out of Method retrieveAllContrats with Success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs (ok)
			L.error("Out of Method retriveAllContrats with Errors :" + e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLContrats :" );
		Contrat c_saved =contratRepository.save(c); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveAllContrats with Success"+ c);
		return c_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat c) { 
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLContrats :" );
		Contrat c_saved = contratRepository.save(c); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveAllContrats with Success"+c);
		return c_saved; 
	}

	@Override
	public void deleteContrat(String reference) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLContrats :" );
		contratRepository.deleteById(Long.parseLong(reference)); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveAllContrats with Success"+ reference);
	}

	@Override
	public Contrat retrieveContrat(String reference) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLContrats :" );
		//Contrat c =  ContratRepository.findByreference(Long.parseLong(reference)).orElse(null);
		Contrat u = contratRepository.findById(Long.parseLong(reference)).get(); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveAllContrats with Success" +reference);
		return u; 
	}

}