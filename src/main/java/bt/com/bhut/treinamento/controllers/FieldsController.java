package bt.com.bhut.treinamento.controllers;


import bt.com.bhut.treinamento.requests.FieldsRequest;
import bt.com.bhut.treinamento.responses.FieldsResponse;
import bt.com.bhut.treinamento.services.ListFieldsService;
import bt.com.bhut.treinamento.services.SaveFieldsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fields")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class FieldsController {
    private final SaveFieldsService saveFieldsService;
    private final ListFieldsService listFieldsService;

    @GetMapping
    public ResponseEntity<List<FieldsResponse>> listFields() {
        return ResponseEntity.status(HttpStatus.OK).body(this.listFieldsService.listAllFields());
    }

    @PostMapping
    public ResponseEntity<Void> createFields(@RequestBody final List<FieldsRequest> fieldsRequestList) {
        saveFieldsService.save(fieldsRequestList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
