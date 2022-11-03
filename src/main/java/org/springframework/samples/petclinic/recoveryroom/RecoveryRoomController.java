package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private static final String VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    
	private final RecoveryRoomService rService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService rService) {
		this.rService = rService;
	}
	
	@GetMapping(value = "/create")
	public String initCreationForm(RecoveryRoom recoveryRoom, ModelMap model) {
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/create")
	public String processCreationForm( @Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) throws DuplicatedRoomNameException {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", recoveryRoom);
			return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
                    this.rService.save(recoveryRoom);
                    return "welcome";
		}
	}
}
