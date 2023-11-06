package com.example.subsub.controller;

import com.example.subsub.domain.Property;
import com.example.subsub.dto.PropertyDTO;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.dto.response.PropertyResponse;
import com.example.subsub.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class PropertyApiController {

    private final PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyDTO> save(@RequestBody AddPropertyRequest request) {
        Property savedProperty = propertyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(PropertyDTO.toPropertyDto(savedProperty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        propertyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PropertyResponse>> findAll() {
        List<PropertyResponse> properties = propertyService.findAll()
                .stream()
                .map(PropertyResponse::new)
                .toList();

        return ResponseEntity.ok().body(properties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> findById(@PathVariable Integer id){
        Property property = propertyService.findById(id);
        return ResponseEntity.ok().body(new PropertyResponse(property));
    }
}
