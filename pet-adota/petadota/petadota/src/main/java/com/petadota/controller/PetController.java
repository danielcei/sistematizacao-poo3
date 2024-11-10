package com.petadota.controller;


import com.petadota.model.Pet;
import com.petadota.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public String listarPets(Model model) {
        List<Pet> pets = petRepository.findAll();
        model.addAttribute("pets", pets);
        return "listarPets";
    }

    @GetMapping("/novo")
    public String novoPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "formPet";
    }

    @PostMapping
    public String salvarPet(@ModelAttribute("pet") Pet pet) {
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/editar/{id}")
    public String editarPetForm(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet inválido: " + id));
        model.addAttribute("pet", pet);
        return "formPet";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarPet(@PathVariable Long id, @ModelAttribute("pet") Pet pet) {
    	Pet petEdit = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet inválido: " + id));
        petRepository.save(petEdit);
        return "redirect:/pets";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/pets";
    }
}