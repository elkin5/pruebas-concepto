package com.ejemplo.mongo.Ejemplomongo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empleados")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private Long salario;
    private Long documento;
    private String areaId;
}
