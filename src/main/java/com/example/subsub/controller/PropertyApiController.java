package com.example.subsub.controller;

import com.example.subsub.domain.Property;
import com.example.subsub.dto.PropertyDTO;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.dto.request.UpdatePropertyRequest;
import com.example.subsub.dto.response.PropertyResponse;
import com.example.subsub.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyApiController {

    private final PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyDTO> save(@RequestBody AddPropertyRequest request, Authentication authentication) {
        Property savedProperty = propertyService.save(request, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(PropertyDTO.toPropertyDto(savedProperty));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        propertyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PropertyResponse>> findBySubjectId(@PathVariable Integer id) {
        List<PropertyResponse> properties = propertyService.findBySubjectId(id)
                .stream()
                .map(PropertyResponse::new)
                .toList();
        return ResponseEntity.ok().body(properties);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<PropertyDTO> update(@PathVariable Integer id, @RequestBody UpdatePropertyRequest request) {
        Property updatedProperty = propertyService.update(id, request);
        return ResponseEntity.ok().body(PropertyDTO.toPropertyDto(updatedProperty));
    }

    @GetMapping("/top")
    public ResponseEntity<List<PropertyResponse>> getTop5Properties(Authentication authentication){
        List<PropertyResponse> top5Properties = propertyService.getTop5PropertiesOrderedByExpiredAt(authentication.getName())
                .stream()
                .map(PropertyResponse::new)
                .toList();
        return ResponseEntity.ok().body(top5Properties);
    }
}
