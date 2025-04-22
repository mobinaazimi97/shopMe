package com.mftplus.shopme.groupProperty;

import com.mftplus.shopme.groupProperty.dto.GroupPropertyDto;


import com.mftplus.shopme.groupProperty.mapper.GroupPropertyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupPropertyService {

    private final GroupPropertyRepository groupPropertyRepository;
    private final GroupPropertyMapper groupPropertyMapper;

    public GroupPropertyService(GroupPropertyRepository groupPropertyRepository, GroupPropertyMapper groupPropertyMapper) {
        this.groupPropertyRepository = groupPropertyRepository;
        this.groupPropertyMapper = groupPropertyMapper;
    }


    public GroupPropertyDto save(GroupPropertyDto groupPropertyDto) {
        GroupProperty groupProperty = groupPropertyMapper.getPropertyDto(groupPropertyDto);
        GroupProperty saved = groupPropertyRepository.save(groupProperty);
        return groupPropertyMapper.toDto(saved);
    }

    public GroupPropertyDto update(Long id, GroupPropertyDto groupPropertyDto) {
        GroupProperty existing = groupPropertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroupProperty not found"));
        GroupProperty updatedEntity = groupPropertyMapper.getPropertyDto(groupPropertyDto);
        updatedEntity.setId(existing.getId());
        GroupProperty updated = groupPropertyRepository.save(updatedEntity);
        return groupPropertyMapper.toDto(updated);
    }

    public List<GroupPropertyDto> findAll() {
        return groupPropertyMapper.toDtoAsList(groupPropertyRepository.findAll());
    }

    public GroupPropertyDto findById(Long id) {
        return groupPropertyRepository.findById(id)
                .map(groupPropertyMapper::toDto)
                .orElseThrow(() -> new RuntimeException("GroupProperty not found"));
    }

    public void logicalRemove(Long id) {
        groupPropertyRepository.logicalRemove(id);
    }
}
