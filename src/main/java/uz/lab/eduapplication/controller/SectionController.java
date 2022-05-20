package uz.lab.eduapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.SectionDTO;
import uz.lab.eduapplication.service.SectionService;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @GetMapping()
    public List<SectionDTO> getAllSection(){
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public SectionDTO getSingleSection(@PathVariable UUID id){
        return sectionService.getOneSection(id);
    }

    @PostMapping()
    public SectionDTO saveSection(@RequestBody SectionDTO sectionDTO){
        return sectionService.saveSection(sectionDTO);
    }

    @PutMapping()
    public SectionDTO editSection( @RequestBody SectionDTO sectionDTO){
        return sectionService.editSection(sectionDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteSection(@PathVariable UUID id){
        return sectionService.deleteSection(id);
    }
}
