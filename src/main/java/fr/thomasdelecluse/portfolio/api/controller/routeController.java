package fr.thomasdelecluse.portfolio.api.controller;

import fr.thomasdelecluse.portfolio.api.repository.UtilisateurRepository;
import fr.thomasdelecluse.portfolio.api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController
public class routeController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @GetMapping("/")
    List<Utilisateur> getAll() {
        return StreamSupport.stream(utilisateurRepository.findAll().spliterator(), false).toList();
    }

    @DeleteMapping("/util/{id}")
    void deleteEmployee(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }

    @PostMapping("/add")
    Utilisateur newUtilisateur(@RequestBody Utilisateur newUtilisateur) {
        return utilisateurRepository.save(newUtilisateur);
    }

}
