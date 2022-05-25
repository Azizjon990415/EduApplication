package uz.lab.eduapplication.service;

import uz.lab.eduapplication.DTO.SectionDTO;
import uz.lab.eduapplication.DTO.SectionWithoutBookDTO;
import uz.lab.eduapplication.DTO.SectionWithTestDTO;
import uz.lab.eduapplication.domain.Section;

import java.util.List;
import java.util.UUID;

public interface SectionService {
    public List<SectionDTO> getAllSections();

    public SectionDTO getOneSection(UUID id);

    public SectionDTO saveSection(SectionDTO sectionDTO);

    public SectionDTO editSection(SectionDTO sectionDTO);

    public String deleteSection(UUID id);

    public List<SectionWithoutBookDTO> getSectionwithBookId(UUID bookId);

    SectionWithTestDTO getSectionWithTests(UUID sectionid);
}
