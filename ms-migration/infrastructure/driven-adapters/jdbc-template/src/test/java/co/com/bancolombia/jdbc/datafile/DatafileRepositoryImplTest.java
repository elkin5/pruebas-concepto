package co.com.bancolombia.jdbc.datafile;

import co.com.bancolombia.jdbc.datafile.config.JdbcConfig;
import co.com.bancolombia.model.data.Datafile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = JdbcConfig.class)
// @ContextConfiguration(classes = JdbcConfig.class)
class DatafileRepositoryImplTest {

    @Autowired private DatafileRepositoryImpl impl;

    @BeforeEach
    void setUp() {
        assertNotNull(impl, "Es nulo");
    }

    @Test
    void metodoTestWhenDataIncorrectThenException() {
        Datafile d = Datafile.builder().tableName("").columnsName(new ArrayList<>()).build();
        assertThrows(
                Exception.class,
                () -> {
                    impl.saveDatafile(d);
                });
    }
}
