package org.reciprocity.aaservice.siteconfig.providedservices;

import org.reciprocity.aaservice.model.GenericMessage;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProvidedServicesController {

    private ProvidedServicesService providedServicesService;

    @Autowired
    private ProvidedServicesController(ProvidedServicesService providedServicesService) {
        this.providedServicesService = providedServicesService;
    }


    @GetMapping(value="/available-services")
    public ResponseEntity<List<ProvidedService>> getAllServices() {
        return new ResponseEntity<>(providedServicesService.retrieveAllProvidedServices(), HttpStatus.OK);
    }
    @GetMapping(value="/available-service")
    public ResponseEntity<List<ProvidedService>> getAllServices(@PathVariable long id) {
        return new ResponseEntity<>(providedServicesService.retrieveAllProvidedServices(), HttpStatus.OK);
    }

    @PostMapping(value="/available-service")
    public ResponseEntity<String> saveNewAvailableService(@RequestBody ProvidedServiceRequest request) {
        providedServicesService.saveNewProvidedService(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/available-service")
    public ResponseEntity<String> updateAvailableService(@RequestBody ProvidedServiceRequest request) {
        providedServicesService.updateProvidedService(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/available-service/{id}")
    public ResponseEntity<GenericMessage> deleteAvailableService(@PathVariable Long id) {
        providedServicesService.deleteProvidedService(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
