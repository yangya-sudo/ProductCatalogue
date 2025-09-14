package src.main.java.org.example.controller;

import org.generated.tmfapi.controller.ProductOfferingApi;
import org.generated.tmfapi.model.ProductOffering;
import org.generated.tmfapi.model.ProductOfferingFVO;
import org.generated.tmfapi.model.ProductOfferingMVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import src.main.java.org.example.service.ProductOfferingService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductOfferingApiImplementation implements ProductOfferingApi {

    @Autowired
    ProductOfferingService productOfferingService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ProductOfferingApi.super.getRequest();
    }

    @Override
    public ResponseEntity<ProductOffering> createProductOffering(ProductOfferingFVO productOfferingFVO, String fields) {
        return ProductOfferingApi.super.createProductOffering(productOfferingFVO, fields);
    }

    @Override
    public ResponseEntity<Void> deleteProductOffering(String id) {
        return ProductOfferingApi.super.deleteProductOffering(id);
    }

    @Override
    public ResponseEntity<List<ProductOffering>> listProductOffering(String fields, Integer offset, Integer limit) {
        return new ResponseEntity<>(productOfferingService.getProductOfferingList(), HttpStatus.OK);
        //return ProductOfferingApi.super.listProductOffering(fields, offset, limit);
    }

    @Override
    public ResponseEntity<ProductOffering> patchProductOffering(String id, ProductOfferingMVO productOfferingMVO, String fields) {
        return ProductOfferingApi.super.patchProductOffering(id, productOfferingMVO, fields);
    }

    @Override
    public ResponseEntity<ProductOffering> retrieveProductOffering(String id, String fields) {
        return ProductOfferingApi.super.retrieveProductOffering(id, fields);
    }
}
