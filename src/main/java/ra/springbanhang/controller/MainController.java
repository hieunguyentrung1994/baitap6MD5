package ra.springbanhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springbanhang.model.dto.reponse.CatagoryReponse;
import ra.springbanhang.model.dto.reponse.ProductReponse;
import ra.springbanhang.model.dto.request.CatagoryRequest;
import ra.springbanhang.model.dto.request.ProductRequest;
import ra.springbanhang.service.ICatagorySercice;
import ra.springbanhang.service.IProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/Home")
public class MainController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICatagorySercice catagorySercice;

    @GetMapping("/catagory")
    public ResponseEntity<List<CatagoryReponse>> findallCatagory() {
        return new ResponseEntity<List<CatagoryReponse>>(catagorySercice.finAll(), HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<List<ProductReponse>> findallProduct() {
        return new ResponseEntity<List<ProductReponse>>(productService.finAll(), HttpStatus.OK);
    }

    @GetMapping("/catagory/{id}")
    public ResponseEntity<CatagoryReponse> findCatagoryById(@PathVariable Long id) {
        CatagoryReponse response = catagorySercice.findById(id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductReponse> findProductById(@PathVariable Long id) {
        ProductReponse response = productService.findById(id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/catagory/ADD")
    public ResponseEntity<CatagoryReponse> addCatagory(@RequestBody CatagoryRequest request) {
        return new ResponseEntity<>(catagorySercice.save(request), HttpStatus.OK);
    }

    @PostMapping("/product/ADD")
    public ResponseEntity<ProductReponse> addProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.save(request), HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductReponse> updateProduct(@RequestBody @Valid ProductRequest request, @PathVariable Long id){
        return new ResponseEntity<>(productService.update(request,id),HttpStatus.CREATED);
    }
    @PutMapping("/catagory/{id}")
    public ResponseEntity<CatagoryReponse> updateCatagory(@RequestBody @Valid CatagoryRequest request, @PathVariable Long id){
        return new ResponseEntity<>(catagorySercice.update(request,id),HttpStatus.CREATED);
    }
    @DeleteMapping("/catagory/delete/{id}")
    public ResponseEntity<CatagoryReponse> deleteCatagory(@PathVariable Long id){
       return new ResponseEntity<>(catagorySercice.delete(id),HttpStatus.OK);
    }
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<ProductReponse> deleteProduct(@PathVariable Long id){
       return new ResponseEntity<>(productService.delete(id),HttpStatus.OK);
    }
}
