package org.reciprocity.aaservice.siteconfig;

import org.reciprocity.aaservice.model.GenericMessage;
import org.reciprocity.aaservice.model.ProvidedService;
import org.reciprocity.aaservice.model.ProvidedServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteConfigController {

    private SiteConfigService siteConfigService;

    @Autowired
    private SiteConfigController(SiteConfigService siteConfigService) {
        this.siteConfigService = siteConfigService;
    }


    @GetMapping(value="/available-services")
    public ResponseEntity<List<ProvidedService>> getAllServices() {
        return new ResponseEntity<>(siteConfigService.retrieveAllProvidedServices(), HttpStatus.OK);
    }

    @PostMapping(value="/available-service")
    public ResponseEntity<String> saveNewAvailableService(@RequestBody ProvidedServiceRequest request) {
        siteConfigService.saveNewProvidedService(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/available-service/{id}")
    public ResponseEntity<GenericMessage> deleteAvailableService(@PathVariable Long id) {
        siteConfigService.deleteProvidedService(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
