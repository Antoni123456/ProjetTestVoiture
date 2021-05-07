package mg.ingenosya.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.ingenosya.demo.models.Commentaire;
import mg.ingenosya.demo.repository.CommentaireRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class CommentaireController {
	
	@Autowired
	private CommentaireRepository repository;
	
	/**
	 * Affichage de la liste
	 * @return liste commentaires
	 */
	@GetMapping(path = "/findAllComments")
	public ResponseEntity<Object> getAllComments(){
		try {
			List<Commentaire> listComments = repository.findAll();
			return new ResponseEntity<>(listComments,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Sauvegarder l'objet commentaire
	 * @param cm
	 * @return objet cm
	 */
	@PostMapping(path = "/saveComment")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> save(@RequestBody Commentaire cm){
		try {
			cm.setDateComment(new Date());
			repository.save(cm);
			return new ResponseEntity<>(cm,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
