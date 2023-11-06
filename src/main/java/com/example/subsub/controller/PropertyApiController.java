package com.example.subsub.controller;

import com.example.subsub.domain.Property;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class PropertyApiController {

    private final PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> save(@RequestBody AddPropertyRequest request) {
        Property savedProperty = propertyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProperty);
    }

    @DeleteMapping("/{subjectId}/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer subjectId, @PathVariable Integer id){
        propertyService.delete(subjectId, id);
        return ResponseEntity.ok().build();
    }
}
