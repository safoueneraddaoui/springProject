package tn.iit.control;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@Controller
@RequestMapping("/compte")
public class CompteController {

	private final CompteService compteService;
	private final ClientService clientService;

	public CompteController(CompteService compteService,ClientService clientService) {
		super();
		this.compteService = compteService;
		this.clientService = clientService;
	}

	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("comptes", compteService.getAll());
		return "comptes";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("clients", clientService.getAll());
		return "addcompte";
	}

	@PostMapping("/save")
	public String save(@RequestParam(name = "solde", required = true) float solde,
					   @RequestParam(name = "cin", required = true) String cin) {
		Client client = clientService.findById(cin);
		Compte compte = new Compte(solde, client);
		compteService.save(compte);
		return "redirect:/compte/all";
	}

	@GetMapping("/delete/{rib}")
	public String delete(@PathVariable(value = "rib") Long rib) {
		compteService.delete(rib);

		return "redirect:/compte/all";
	}

	@ResponseBody
	@GetMapping("/delete-ajax")

	public void deleteajax(@RequestParam(value = "rib" , required = true) Long rib) {
		compteService.delete(rib);
	}

	@PostMapping("/update")
	public String update(@RequestParam(name = "rib", required = true) Long rib, Model model) {

		model.addAttribute("compte", compteService.findById(rib));
		model.addAttribute("comptes", compteService.getAll());
		return "edit-compte";
	}


}