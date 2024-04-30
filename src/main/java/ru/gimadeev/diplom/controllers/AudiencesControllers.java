package ru.gimadeev.diplom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gimadeev.diplom.dto.AudiencesForm;
import ru.gimadeev.diplom.services.AudiencesService;

@Controller
@RequestMapping(value = "/audiences")
@RequiredArgsConstructor
public class AudiencesControllers {

    private final AudiencesService audiencesService;

    @GetMapping
    public String getAudiencesPage(Model model) {
        model.addAttribute("audiencesList", audiencesService.getAllAudiences());
        return "audiences_page";
    }

    @PostMapping
    public String addAudiences(AudiencesForm audiences) {
        audiencesService.addAudiences(audiences);
        return "redirect:/audiences";
    }

    @GetMapping("/{audience-id}")
    public String getAudiencesPage(@PathVariable("audience-id") Long id, Model model) {
        model.addAttribute("audience", audiencesService.getAudience(id));
        return "audience_page";
    }

    @PostMapping("/{audience-id}/update")
    public String updateAudiences(@PathVariable("audience-id") Long audiencesId, AudiencesForm audiences) {
        audiencesService.updateAudiences(audiencesId, audiences);
        return "redirect:/audiences/" + audiencesId;
    }

    @GetMapping("/{audience-id}/delete")
    public String deleteAudiences(@PathVariable("audience-id") Long audiencesId) {
        audiencesService.deleteAudiences(audiencesId);
        return "redirect:/audiences";
    }
}
