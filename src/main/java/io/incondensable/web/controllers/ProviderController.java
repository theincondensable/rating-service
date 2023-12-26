package io.incondensable.web.controllers;

import io.incondensable.business.services.assets.ProviderService;
import io.incondensable.global.aspects.log.aspect.ControllerLog;
import io.incondensable.web.dto.assets.ProviderResponseDto;
import io.incondensable.web.mappers.ProviderMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abbas
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService service;
    private final ProviderMapper mapper;

    public ProviderController(ProviderService providerService, ProviderMapper mapper) {
        this.service = providerService;
        this.mapper = mapper;
    }

    @ControllerLog
    @GetMapping("/")
    public ResponseEntity<List<ProviderResponseDto>> getAllProviders() {
        return ResponseEntity.ok(
                service.getAllProviders().stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

}
