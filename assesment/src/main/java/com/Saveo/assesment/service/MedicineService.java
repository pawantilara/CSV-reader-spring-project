package com.Saveo.assesment.service;

import com.Saveo.assesment.model.Medicine;
import com.Saveo.assesment.model.Response;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MedicineService {
    ResponseEntity<Response> uploadCSVFile(MultipartFile file);
    Object getMedicineDetails(Integer id);
    List<Medicine> getAllData();
    List<String> searchMedicineByName(String name);
    Response placeOrder(Medicine medicine);
}
