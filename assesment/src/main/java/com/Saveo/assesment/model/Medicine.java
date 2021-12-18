package com.Saveo.assesment.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue
    Integer uniqueCode;
    String name;
    String batchNumber;
    String expiryDate;
    Double balanceQty;
    String packaging;
    String schemes;
    Double mrp;
    String manufacturer;
    String hsnCode;
}
