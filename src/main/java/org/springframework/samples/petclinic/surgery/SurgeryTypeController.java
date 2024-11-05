package org.springframework.samples.petclinic.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/surgerytypes")
public class SurgeryTypeController {

    private final SurgeryTypeService surgeryTypeService;

    @Autowired
    public SurgeryTypeController(SurgeryTypeService surgeryTypeService) {
        this.surgeryTypeService = surgeryTypeService;
    }

    @GetMapping
    public ResponseEntity<List<SurgeryType>> getAll() {
        List<SurgeryType> list = surgeryTypeService.findSurgeryTypes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurgeryType> getById(@PathVariable Integer id) {
        SurgeryType st = surgeryTypeService.findSurgeryTypeById(id);
        if(st == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    
    
}
