package uz.lab.eduapplication.service;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.SectionDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public interface SectionService {
    public List<SectionDTO> getAllSections();
    public SectionDTO getOneSection(UUID id);
    public SectionDTO saveSection(SectionDTO sectionDTO);
    public SectionDTO editSection(SectionDTO sectionDTO);
    public String deleteSection(UUID id);
}
