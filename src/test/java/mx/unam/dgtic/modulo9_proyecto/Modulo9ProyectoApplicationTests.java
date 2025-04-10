package mx.unam.dgtic.modulo9_proyecto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class Modulo9ProyectoApplicationTests {

    @Test
    void contextLoads() {
    }

}
