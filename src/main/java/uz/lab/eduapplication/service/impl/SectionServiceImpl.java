package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.SectionDTO;
import uz.lab.eduapplication.DTO.SectionWithTestDTO;
import uz.lab.eduapplication.DTO.SectionWithoutBookDTO;
import uz.lab.eduapplication.DTO.TestWithoutSectionDTO;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.mapper.SectionMapper;
import uz.lab.eduapplication.repository.SectionRepository;
import uz.lab.eduapplication.service.SectionService;
import uz.lab.eduapplication.service.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {
    private SectionRepository sectionRepository;
    private SectionMapper sectionMapper;
    private TestService testService;

    @Override
    public List<SectionDTO> getAllSections() {
        List<Section> sections = sectionRepository.findAll();
        List<SectionDTO> sectionDTOS = new ArrayList<>();
        sections.forEach(section -> {
            SectionDTO sectionDTO = sectionMapper.mapSectionDomainToSectionDTO(section);
            sectionDTOS.add(sectionDTO);
        });
        return sectionDTOS;
    }

    @Override
    public SectionDTO getOneSection(UUID id) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        if (optionalSection.isPresent()){
            Section section = optionalSection.get();
            SectionDTO sectionDTO = sectionMapper.mapSectionDomainToSectionDTO(section);
            return sectionDTO;
        } else {
            throw new NullPointerException("I can not find the Section with  id" + id);
        }
    }

    @Override
    public SectionDTO saveSection(SectionDTO sectionDTO) {
        Section section = sectionMapper.mapSectionDTOToSectionDomain(sectionDTO);
        Section savedSection = sectionRepository.save(section);
        SectionDTO savedSectionDTO = sectionMapper.mapSectionDomainToSectionDTO(savedSection);
        return savedSectionDTO;
    }

    @Override
    public SectionDTO editSection(SectionDTO sectionDTO) {
        boolean exists = sectionRepository.existsById(UUID.fromString(sectionDTO.getId()));
        if (exists) {
            Section section = sectionMapper.mapSectionDTOToSectionDomain(sectionDTO);
            section.setId(UUID.fromString(sectionDTO.getId()));
            Section savedSection = sectionRepository.save(section);
            SectionDTO savedSectionDTO = sectionMapper.mapSectionDomainToSectionDTO(savedSection);
            return savedSectionDTO;
        }else {
            throw new NullPointerException("I can not find the Section with  id" + sectionDTO.getId());
        }
    }

    @Override
    public String deleteSection(UUID id) {
        boolean exists = sectionRepository.existsById(id);
        if (exists) {
            sectionRepository.deleteById(id);
            return "Data deleted";
        } else {
            throw new NullPointerException("I can not find the Section with  id" + id);
        }
    }

    @Override
    public List<SectionWithoutBookDTO> getSectionwithBookId(UUID bookId){
        List<Section> sectionsByBookId = sectionRepository.findSectionsByBookId(bookId);
        List<SectionWithoutBookDTO> sectionWithoutBookDTOS = new ArrayList<>();
        sectionsByBookId.forEach(section -> {
            SectionWithoutBookDTO sectionWithoutBookDTO = sectionMapper.mapSectionWithoutBookDTO(section);
            sectionWithoutBookDTOS.add(sectionWithoutBookDTO);
        });
        return sectionWithoutBookDTOS;
    }

    @Override
    public SectionWithTestDTO getSectionWithTests(UUID sectionid) {
        Optional<Section> optionalSection = sectionRepository.findById(sectionid);
        if (optionalSection.isPresent()){
            List<TestWithoutSectionDTO> testWithSectionId = testService.getTestWithSectionId(sectionid);
            Section section = optionalSection.get();
            SectionWithTestDTO sectionWithTestDTO = sectionMapper.mapSectionWithTestDTO(section, testWithSectionId);
            return sectionWithTestDTO;
        } else {
            throw  new NullPointerException();
        }
    }
}
