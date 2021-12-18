package com.Saveo.assesment.controller;

import com.Saveo.assesment.model.Medicine;
import com.Saveo.assesment.model.Response;
import com.Saveo.assesment.service.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    /**
     * uploadCSV file
     * @param file
     * @return response
     */
    @PostMapping("/uploadCSV")
    public ResponseEntity<Response> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        return medicineService.uploadCSVFile(file);
    }
    /**
     *
     * @param id
     * @return medicine details
     */
    @GetMapping("/getMedicineDetails/{id}")
    public Object getMedicineDetails(@PathVariable(value = "id") Integer id) {
    return medicineService.getMedicineDetails(id);
    }
    /**
     *
     * @return all the complete list
     */
    @GetMapping("/")
    public List<Medicine> getAllData() {
        return medicineService.getAllData();
    }
    /**
     *
     * @param name
     * @return list of names based on the search
     */
    @GetMapping("searchMedicine/{name}")
    public  List<String> searchMedicineByName(@PathVariable (value = "name") String name) {
        return  medicineService.searchMedicineByName(name);
    }
    /**
     *
     * @param medicine
     * @return Unique code of new entry
     */
    @PostMapping("/placeOrder")
    public Response placeOrder(@RequestBody Medicine medicine) {
        return  medicineService.placeOrder(medicine);
    }
}
