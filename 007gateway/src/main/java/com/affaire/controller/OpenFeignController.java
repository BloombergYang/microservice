package com.affaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.affaire.feign.ProviderFeign;

@RestController
@RequestMapping("/consumer")
public class OpenFeignController {
	@Autowired
	private ProviderFeign providerFeign;
	
	@GetMapping("hi")
    public String hi() {
        return this.providerFeign.hello();
    }
}
