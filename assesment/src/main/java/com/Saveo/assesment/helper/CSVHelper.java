package com.Saveo.assesment.helper;

import com.Saveo.assesment.model.Medicine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Medicine> csvToTutorials(InputStream is) {
        BufferedReader br;
        List<Medicine> medicines = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(is) );
            int count = 0;
            while ((line = br.readLine()) != null ) {
                if(count==0) {
                    count++;
                    continue;
                }
                String[] data = line.split(",");
                Medicine medicine = new Medicine();
                medicine.setName(data[0]);
                medicine.setBatchNumber(data[1]);
                medicine.setExpiryDate(data[2]);
                medicine.setBalanceQty(Double.parseDouble(data[3]));
                medicine.setPackaging(data[4]);
                medicine.setSchemes(data[6]);
                medicine.setMrp(Double.parseDouble(data[7]));
                medicine.setManufacturer(data[8]);
                medicine.setHsnCode(data[9]);
                medicines.add(medicine);
            }
            return medicines;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return medicines;
    }
    }