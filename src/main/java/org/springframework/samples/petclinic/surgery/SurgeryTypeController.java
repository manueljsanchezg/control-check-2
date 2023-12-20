package org.springframework.samples.petclinic.surgery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/surgerytypes")
@SecurityRequirement(name = "bearerAuth")
public class SurgeryTypeController {
    private final SurgeryTypeService stService;

	@Autowired
	public SurgeryTypeController(SurgeryTypeService stService) {
		this.stService=stService;
	}

    @GetMapping
	public ResponseEntity<List<SurgeryType>> findAll() {
        return new ResponseEntity<>(this.stService.repo.findAll(), HttpStatus.OK);
	}

    @GetMapping("{id}")
	public ResponseEntity<SurgeryType> findById(@PathVariable("id") int id) {
        Optional<SurgeryType> st = this.stService.repo.findById(id);

        if (!st.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(st.get(), HttpStatus.OK);
	}
}
