package com.example.l2_20221.controller;

import com.example.l2_20221.Entity.Distributors;
import com.example.l2_20221.repository.DistributorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DistributorsController {
    final DistributorsRepository distributorsRepository;
    public DistributorsController(DistributorsRepository distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }


    @GetMapping(value = "distribuidoras/lista")
    public String index(Model model){
        model.addAttribute("lista", distributorsRepository.findAll());
        return "distribuidoras/lista";
    }

    @GetMapping(value = "distribuidoras/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    }

    @PostMapping(value = "distribuidoras/guardar")
    public String guardar(Distributors distributors){
        distributorsRepository.save(distributors);
        return "redirect:/distribuidoras/lista";
    }

    @GetMapping(value = "distribuidoras/editar")
    public String editaDistribuidoras(@RequestParam("id") Integer id, Model model){
        Optional<Distributors>  optionalDistributors= distributorsRepository.findById(id);
        if(optionalDistributors.isPresent()){
            Distributors distributors = optionalDistributors.get();
            model.addAttribute("dist", distributors);
            return "distribuidoras/editar";
        }else {
            return "redirect:/distribuidoras/lista";
        }

    }

}
