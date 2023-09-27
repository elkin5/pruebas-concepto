package com.ejemplo.mongo.Ejemplomongo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "areas")
public class Area {
    @Id
    private String id;
    private String nombre;
    private List<String> empleados;
    private Empleado jefe;
}
