package co.com.bancolombia.jdbc.datafile;

import co.com.bancolombia.model.data.Datafile;
import co.com.bancolombia.model.data.gateways.DatafileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatafileRepositoryImpl implements DatafileRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Datafile saveDatafile(Datafile datafile) {

        String sql =
                "INSERT INTO "
                        + datafile.getTableName()
                        + datafile.getColumnsName().toString().replace("[", "(").replace("]", ")")
                        + "VALUES(?,?,?)";

        jdbcTemplate.batchUpdate(
                sql,
                datafile.getDataRows(),
                100,
                (PreparedStatement ps, List<String> dataRow) -> {

                    String name = dataRow.get(0);
                    Date startDate = Date.valueOf(dataRow.get(1));
                    String status = dataRow.get(2);
                    int value = Integer.parseInt(dataRow.get(3));

                    ps.setString(1, name);
                    ps.setDate(2, startDate);
                    ps.setString(3, status);
                    ps.setInt(4, value);
                });

        return datafile;
    }
}
