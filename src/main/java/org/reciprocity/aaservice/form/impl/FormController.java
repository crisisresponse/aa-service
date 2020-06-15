package org.reciprocity.aaservice.form.impl;

import org.reciprocity.aaservice.form.FormService;
import org.reciprocity.aaservice.model.CommunityMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    private FormService formService;

    @Autowired
    private FormController(FormService formService) {
        this.formService = formService;
    }


    @PostMapping(value="/form")
    public String addCommunityMember(@RequestBody CommunityMemberRequest request) {



        formService.saveForm(request);

        return "Hello";
    }
}
