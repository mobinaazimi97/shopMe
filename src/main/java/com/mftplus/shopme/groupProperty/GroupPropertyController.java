package com.mftplus.shopme.groupProperty;


import com.mftplus.shopme.groupProperty.dto.GroupPropertyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/groups")
@Slf4j
public class GroupPropertyController {

    private final GroupPropertyService groupPropertyService;

    public GroupPropertyController(GroupPropertyService groupPropertyService) {
        this.groupPropertyService = groupPropertyService;
    }

    @GetMapping
    public List<GroupPropertyDto> getGroupProperties() {
        return groupPropertyService.findAll();

    }
}
