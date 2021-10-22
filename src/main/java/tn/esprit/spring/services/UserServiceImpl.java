package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter  (ok)
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode (ok)
			L.info("In Method retriveALLUsers :" );
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   (ok)
			    L.debug("user :" + user.getLastName());
			   // int i =1/0;
			} 
			// TODO Log à ajouter à la fin de la méthode (ok)
			L.error("Out of Method retrieveALLUsers with Success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs (ok)
			L.error("Out of Method retriveALLUsers with Errors :" + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLUsers :" );
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveALLUsers with Success"+ u);
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLUsers :" );
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveALLUsers with Success"+u);
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLUsers :" );
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveALLUsers with Success"+ id);
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode (ok)
		L.info("In Method retriveALLUsers :" );
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode (ok)
		L.error("Out of Method retrieveALLUsers with Success" +id);
		return u; 
	}

}