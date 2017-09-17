package de.weimarnetz.registrator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

import de.weimarnetz.registrator.model.Node;
import de.weimarnetz.registrator.repository.RegistratorRepository;

@Controller
public class WebController {

    @Inject
    private RegistratorRepository registratorRepository;

    @GetMapping("/{network}")
    public String displayNodesByNetwork(
            @PathVariable() String network,
            Model model
    ) {
        List<Node> allNodes = registratorRepository.findAllByNetwork(network);
        model.addAttribute("nodeList", allNodes);
        model.addAttribute("network", network);
        model.addAttribute("name", "Weimarnetz Registrator");
        return "allNodes";
    }

    @GetMapping("/")
    public String displayNodes(
            Model model
    ) {
        return displayNodesByNetwork("ffweimar", model);
    }

}
