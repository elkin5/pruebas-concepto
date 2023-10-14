package co.com.bancolombia.model.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Datafile {
    private String tableName;
    private List<String> columnsName;
    private List<List<String>> dataRows;
}
