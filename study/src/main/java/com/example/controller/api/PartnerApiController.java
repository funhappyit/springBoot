package com.example.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.CrudController;
import com.example.model.entity.Partner;
import com.example.model.network.request.PartnerApiRequest;
import com.example.model.network.response.PartnerApiResponse;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner>{

}
