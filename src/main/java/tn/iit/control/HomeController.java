package tn.iit.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@Controller
@RequestMapping("/")
public class HomeController {
    private final CompteService compteService;
    private final ClientService clientService;

    public HomeController(CompteService compteService, ClientService clientService) {
        super();
        this.compteService = compteService;
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        /*model.addAttribute("countclient", clientService.getCount());
        model.addAttribute("countcompte", compteService.getCount());
        model.addAttribute("summoney", compteService.getSum());
        model.addAttribute("topmoney", compteService.getTop());*/
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/login";
    }
}
