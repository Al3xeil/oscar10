package com.fitness.login.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.competence.CompetenceStatus;
import com.fitness.login.model.dtos.CompetenceCategoryDTO;
import com.fitness.login.model.dtos.CompetenceDTO;
import com.fitness.login.model.dtos.CompetenceStatusDTO;
import com.fitness.login.model.dtos.CompetenceTypeDTO;
import com.fitness.login.service.CompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/competence")
public class CompetenceRestController {

	@Autowired
	private CompetenceService competenceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Competence getCompentenceDetail(@PathVariable("id") int competenceId) {
		Competence competence = competenceService.getCompetenceById(competenceId);
		if (competence == null) {
			return null;
		}
		return competence;
	}

	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public Resources<?> getCompentenceByName(@PathVariable("name") String competenceName) {
		List<CompetenceDTO> competences = competenceService.getCompetencesByName(competenceName).stream()
				.map(CompetenceDTO::new).collect(Collectors.toList());
		if (competences == null) {
			return null;
		}
		return new Resources<>(competences);
	}

	@RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
	public Resources<?> getCompentenceByType(@PathVariable("id") int competenceTypeId) {
		List<CompetenceDTO> allCompetencesForType = competenceService.getAllCompetenceByType(competenceTypeId).stream()
				.map(CompetenceDTO::new).collect(Collectors.toList());
		return new Resources<>(allCompetencesForType);
	}

	@RequestMapping(value = "/type", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceType() {
		List<CompetenceTypeDTO> allType = competenceService.getAllTypes().stream().map(CompetenceTypeDTO::new)
				.collect(Collectors.toList());
		return new Resources<>(allType);
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceStatus() {
		List<CompetenceStatusDTO> allStatus = competenceService.getAllStatus().stream().map(CompetenceStatusDTO::new)
				.collect(Collectors.toList());
		return new Resources<>(allStatus);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceCategory() {
		List<CompetenceCategoryDTO> allCategory = competenceService.getAllCategories().stream()
				.map(CompetenceCategoryDTO::new).collect(Collectors.toList());
		return new Resources<>(allCategory);
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public Resources<?> getCompentenceByCategory(@PathVariable("id") int competenceCategoryId) {
		List<CompetenceDTO> allCompetencesForType = competenceService.getAllCompetenceByType(competenceCategoryId).stream()
				.map(CompetenceDTO::new).collect(Collectors.toList());
		return new Resources<>(allCompetencesForType);
	}


	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resources<?> getAllCompetences() {
		List<CompetenceDTO> allCompetences = competenceService.getAllCompetence().stream().map(CompetenceDTO::new)
				.collect(Collectors.toList());
//		for (CompetenceDTO dtos : allCompetences) {
//			dtos.add(linkTo(methodOn(CompetenceRestController.class).getCompentenceDetail(dtos.getCompetence().getId()))
//					.withSelfRel());
//		}
		// User loggedInUser = securityService.findLoggedInUser();
		return new Resources<>(allCompetences);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Competence insertCompetence(@ModelAttribute("competence") Competence competence, Model model) {
		CompetenceStatus statusSuggested = competenceService.getStatusById(CompetenceStatus.STATUS_SUGGESTED_ID);
		competence.setStatus(statusSuggested);
		competenceService.save(competence);

		return competence;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Competence updateCompetence(@RequestBody Competence competence) {
		if (competence.getId() == null) {
			return null;
		}
		competenceService.save(competence);

		return competence;
	}

}
