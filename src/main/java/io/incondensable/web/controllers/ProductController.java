package io.incondensable.web.controllers;

import io.incondensable.business.services.ProductPreviewService;
import io.incondensable.business.services.assets.ProductService;
import io.incondensable.global.aspects.log.aspect.ControllerLog;
import io.incondensable.web.dto.assets.ProductPreviewResponseDto;
import io.incondensable.web.dto.assets.ProductResponseDto;
import io.incondensable.web.mappers.product.ProductMapper;
import io.incondensable.web.mappers.product.ProductPreviewMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author abbas
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService service;

    private final ProductPreviewMapper previewMapper;
    private final ProductPreviewService previewService;

    public ProductController(ProductMapper mapper, ProductService service, ProductPreviewMapper previewMapper, ProductPreviewService previewService) {
        this.mapper = mapper;
        this.service = service;
        this.previewMapper = previewMapper;
        this.previewService = previewService;
    }

    @ControllerLog
    @GetMapping("/")
    @Operation(description = "For Checking purpose only.",
            summary = "Full Information of all Products, information includes details of products being votable, commentable and is open to all.",
            responses = @ApiResponse(responseCode = "200", description = "full information of products")
    )
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(
                service.getAllProducts().stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

    @ControllerLog
    @GetMapping("/preview")
    @Operation(summary = "To get Preview detail of all products, before choosing one.",
            responses = @ApiResponse(responseCode = "200", description = "preview of products")
    )
    public ResponseEntity<List<ProductPreviewResponseDto>> getPreviewAllProducts() {
        return ResponseEntity.ok(
                previewService.getProductsPreview().stream().map(
                        previewMapper::entityToPreviewDto
                ).toList()
        );
    }

    @ControllerLog
    @GetMapping("/{productId}")
    @Operation(summary = "After choosing the Product, the full information is shown to decide whether the product is votable, commentable and is open to all.",
            responses = @ApiResponse(responseCode = "200", description = "full information of a chosen product")
    )
    public ResponseEntity<ProductResponseDto> getProductDetail(@PathVariable long productId) {
        return ResponseEntity.ok(
                mapper.entityToDto(service.getProductById(productId))
        );
    }

    @ControllerLog
    @PutMapping("{productId}/commentable/{flag}")
    public ResponseEntity<ProductResponseDto> changeCommentable(@PathVariable Long productId, @PathVariable boolean flag) {
        return ResponseEntity.ok(
                mapper.entityToDto(
                        service.changeCommentable(productId, flag)
                )
        );
    }

    @ControllerLog
    @PutMapping("{productId}/votable/{flag}")
    public ResponseEntity<ProductResponseDto> changeVotable(@PathVariable Long productId, @PathVariable boolean flag) {
        return ResponseEntity.ok(
                mapper.entityToDto(
                        service.changeVotable(productId, flag)
                )
        );
    }

    @ControllerLog
    @PutMapping("{productId}/open/{flag}")
    public ResponseEntity<ProductResponseDto> changeOpenToAll(@PathVariable Long productId, @PathVariable boolean flag) {
        return ResponseEntity.ok(
                mapper.entityToDto(
                        service.changeOpenToAll(productId, flag)
                )
        );
    }

}
