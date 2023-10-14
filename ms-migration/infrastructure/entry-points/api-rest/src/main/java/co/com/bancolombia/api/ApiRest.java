package co.com.bancolombia.api;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.usecase.client.GetClientUseCase;
import co.com.bancolombia.usecase.createdatafile.CreateDatafileUseCase;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
  //    private final MyUseCase useCase;
  private final CreateDatafileUseCase createDatafileUseCase;
  private final GetClientUseCase getClientUseCase;

  @PostMapping("/upload_data")
  public ResponseEntity<String> uploadData(@RequestParam("csvFile") MultipartFile csvFile) {

    File file = new File(Objects.requireNonNull(csvFile.getOriginalFilename()));
    CsvMapper csvMapper = new CsvMapper();
    csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

    MappingIterator<List<String>> rows = null;
    List<List<String>> data = null;
    try {
      rows = csvMapper.readerFor(List.class).readValues(file);
      data = rows.readAll();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String tableName = data != null ? data.remove(0).get(0) : "";
    List<String> columnsName = data != null ? data.remove(0) : new ArrayList<>();

    this.createDatafileUseCase.createDatafile(tableName, columnsName, data);

    return ResponseEntity.status(HttpStatus.OK).body("Ok");
    // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
    // FileMessage(message));
  }

  @GetMapping(path = "/path")
  public String commandName() {

    File csvFile = null;
    CsvMapper csvMapper = new CsvMapper();
    csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

    MappingIterator<List<String>> rows = null;
    List<List<String>> data = null;
    try {
      rows = csvMapper.readerFor(List.class).readValues(csvFile);
      data = rows.readAll();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String tableName = data != null ? data.remove(0).get(0) : "";
    List<String> columnsName = data != null ? data.remove(0) : new ArrayList<>();

    this.createDatafileUseCase.createDatafile(tableName, columnsName, data);

    return "Hello World";
  }

  @GetMapping(path = "/clients")
  public List<Client> getClients() {
    return this.getClientUseCase.getClientList();
  }

  @GetMapping(path = "/clients/mdm/{mdmKey}")
  public Client getClientByMdmKey(@PathVariable("mdmKey") String mdmKey) {
    return this.getClientUseCase.getClientByMdmKey(mdmKey);
  }
}
