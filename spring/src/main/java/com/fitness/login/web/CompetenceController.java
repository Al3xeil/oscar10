//package com.fitness.login.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.fitness.login.model.CompetenceRating;
//import com.fitness.login.model.competence.Competence;
//import com.fitness.login.model.competence.CompetenceCategory;
//import com.fitness.login.model.competence.CompetenceStatus;
//import com.fitness.login.model.competence.CompetenceType;
//import com.fitness.login.model.user.User;
//import com.fitness.login.service.CompetenceService;
//import com.fitness.login.service.UserService;
//
////@Controller
////@RequestMapping("/competence")
//public class CompetenceController {
//    @Autowired
//    private UserService userService;
//    
//    @Autowired
//    private CompetenceService competenceService;
//  
//    
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public String getCompentenceRating(Model model, @PathVariable("id") int competenceId) {
//    	User loggedInUser = securityService.findLoggedInUser();
//		CompetenceRating rating = userService.getCompetenceRatingFromUser(loggedInUser, competenceId);
//    	if(rating == null){
//    		return "redirect:/mainPage";
//    	}
//    	model.addAttribute("rating", rating);
//        return "competence";
//    }
//    
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getCompentenceDetail(Model model, @PathVariable("id") int competenceId) {
//    	Competence competence = competenceService.getCompetenceById(competenceId);
//    	List<CompetenceType> allCompetenceType = competenceService.getAllTypes();
//    	List<CompetenceCategory> allCompetenceCategory = competenceService.getAllCategories();
//    	List<CompetenceStatus> allCompetenceStatus = competenceService.getAllStatus();
//    	model.addAttribute("types", allCompetenceType);
//    	model.addAttribute("categories", allCompetenceCategory);
//    	model.addAttribute("statusAll", allCompetenceStatus);
//    	if(competence == null){
//    		return "redirect:/mainPage";
//    	}
//    	model.addAttribute("competence", competence);
//        return "competenceDetail";
//    }
//    
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getAllCompetences(Model model) {
//    	List<Competence> allCompetences = competenceService.getAllCompetence();
//    	List<CompetenceType> allCompetenceType = competenceService.getAllTypes();
//    	User loggedInUser = securityService.findLoggedInUser();
//    	model.addAttribute("competences", allCompetences);
//    	model.addAttribute("types", allCompetenceType);
//    	model.addAttribute("competence", new Competence());
//    	model.addAttribute("user", loggedInUser);
//        return "competence";
//    }
//    
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String insertCompetence(@ModelAttribute("competence") Competence competence, Model model) {
//    	CompetenceStatus statusSuggested = competenceService.getStatusById(CompetenceStatus.STATUS_SUGGESTED_ID);
//    	competence.setStatus(statusSuggested);
//    	competenceService.save(competence);
//
//        return "redirect:/competence/";
//    }
//    
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public String updateCompetence(@ModelAttribute("competence") Competence competence, Model model) {
//    	if(competence.getId() == null){
//    		return "redirect:/competence/";
//    	}
//    	competenceService.save(competence);
//
//        return "redirect:/competence/";
//    }
//
//}
