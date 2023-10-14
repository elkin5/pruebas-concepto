package co.com.bancolombia.usecase.createdatafile;

import co.com.bancolombia.model.data.Datafile;
import co.com.bancolombia.model.data.gateways.DatafileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
public class CreateDatafileUseCase {

    private final DatafileRepository datafileRepository;

    public Datafile createDatafile(
            String tableName, List<String> columnsName, List<List<String>> data) {

        Datafile datafile =
                Datafile.builder()
                        .tableName(tableName)
                        .columnsName(columnsName)
                        .dataRows(data)
                        .build();

        return this.datafileRepository.saveDatafile(datafile);
    }
}
