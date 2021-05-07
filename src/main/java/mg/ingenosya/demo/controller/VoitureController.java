package mg.ingenosya.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.ingenosya.demo.models.Commentaire;
import mg.ingenosya.demo.models.Voiture;
import mg.ingenosya.demo.repository.CommentaireRepository;
import mg.ingenosya.demo.repository.VoitureRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class VoitureController {
	
	ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private CommentaireRepository commentRepository;
	
	/**
	 * Afficher la liste des voitures
	 * @return listeVoitures
	 */
	@GetMapping(path = "/findAllVoitures")
	public ResponseEntity<Object> getAllVoitures(){
		try {
			List<Voiture> listeVoitures = voitureRepository.findAll();
			return new ResponseEntity<>(listeVoitures, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Detail d'une voiture avec des commentaires
	 * @param idVoiture
	 * @return objet map
	 */
	@GetMapping(path = "/details")
	public ResponseEntity<Object> getDetailVehiculeWithComment(@RequestParam Long idVoiture){
		try {
			List<Voiture> ls = voitureRepository.findByIdVoiture(idVoiture);
			List<Commentaire> lc = commentRepository.getCommentByVoiture(idVoiture);
			Map<String, Object> map = new HashMap<>();
			map.put("voiture", ls);
			map.put("comments", lc);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Enregistrer l'info voiture
	 * @param vm
	 * @return objet voiture
	 */
	@PostMapping(path = "/saveVoiture")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> saveVoiture(@RequestBody Voiture vm){
		try {
			voitureRepository.save(vm);
			return new ResponseEntity<>(vm, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/* Remarque:
	 * J'utilise ResponseEntity comme type de la fonction, peu importe leur role
	 */

}
