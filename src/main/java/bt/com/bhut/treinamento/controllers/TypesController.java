package bt.com.bhut.treinamento.controllers;


import bt.com.bhut.treinamento.requests.FieldsRequest;
import bt.com.bhut.treinamento.responses.FieldsResponse;
import bt.com.bhut.treinamento.responses.TypesResponse;
import bt.com.bhut.treinamento.services.ListFieldsService;
import bt.com.bhut.treinamento.services.ListTypesService;
import bt.com.bhut.treinamento.services.SaveFieldsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class TypesController {
    private final ListTypesService listTypesService;

    @GetMapping
    public ResponseEntity<List<TypesResponse>> listTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.listTypesService.listTypes());
    }
}
