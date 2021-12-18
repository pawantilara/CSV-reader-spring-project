package com.Saveo.assesment.service.impl;

import com.Saveo.assesment.helper.CSVHelper;
import com.Saveo.assesment.model.Medicine;
import com.Saveo.assesment.model.Response;
import com.Saveo.assesment.repository.MedicineRepository;
import com.Saveo.assesment.service.MedicineService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class MedicineServiceServiceImpl implements MedicineService {
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public ResponseEntity<Response> uploadCSVFile(MultipartFile file) {
        log.info("uploadCSVFile method called");
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<Medicine> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
                medicineRepository.saveAll(tutorials);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new Response(message, true));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message, false));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(message, false));
    }
    @Override
    public  Object getMedicineDetails(Integer id) {
        log.info("getMedicineDetails method  called, unique code is : {}", id);
        try {
            return medicineRepository.findByUniqueCode(id);
        }catch (Exception e) {
            return  new ResponseEntity<Response>(new Response("id does not exit ", false), HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public  List<Medicine>getAllData() {
        log.info("getAllData method  called to get complete list");
        return medicineRepository.findAll();
    }
    @Override
    public List<String>searchMedicineByName(String name) {
        log.info("searchMedicineByName method called, search input is :{}", name);
        List<Medicine> result =  medicineRepository.findByNameStartingWith(name);
        List<String> response = new ArrayList<>();
        result.forEach(medicine ->response.add(medicine.getName()) );
        return response;
    }
    @Override
    public  Response placeOrder(Medicine medicine) {
        log.info("placeOrder method called, details are :{}", medicine.toString());
        medicineRepository.save(medicine);
        List<Medicine> medicines = medicineRepository.findAll();
        String msg = "Order places successfully , order is is :"+ medicines.get(medicines.size() -1).getUniqueCode();
        return new Response(msg, true);
    }
}
