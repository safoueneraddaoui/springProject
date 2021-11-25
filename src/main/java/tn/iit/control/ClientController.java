package tn.iit.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.iit.entity.Client;
import tn.iit.service.ClientService;


@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {

        model.addAttribute("clients", clientService.getAll());
        return "clients";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "addclient";
    }

    @PostMapping("/save")
    public String save(@RequestParam(name = "cin", required = true) String cin,
                       @RequestParam(name = "nom", required = true) String nom,
                       @RequestParam(name = "prenom", required = true) String prenom) {

        Client client = new Client(cin, nom, prenom);
        clientService.save(client);
        return "redirect:/client/all";
    }

    @GetMapping("/delete/{cin}")
    public String delete(@PathVariable(value = "cin") String cin) {
        clientService.delete(cin);

        return "redirect:/client/all";
    }

    @GetMapping("/show/{cin}")
    public String show(@PathVariable(value = "cin") String cin, Model model) {
        model.addAttribute("client", clientService.findById(cin));
        return "show-client";
    }

    @ResponseBody
    @GetMapping("/delete-ajax")
    public void deleteajax(@RequestParam(value = "cin", required = true) String cin) {
        clientService.delete(cin);
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "cin", required = true) String cin, Model model) {

        model.addAttribute("client", clientService.findById(cin));
        return "edit-client";
    }

    @PostMapping("/update_data")
    public String update_data(@ModelAttribute Client client) {

        clientService.update(client);
        return "redirect:/client/all";
    }
}