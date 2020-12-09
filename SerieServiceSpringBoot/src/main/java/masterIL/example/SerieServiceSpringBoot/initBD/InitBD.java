package masterIL.example.SerieServiceSpringBoot.initBD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class InitBD implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Création et initialisation de la BDD");

        String sqlStatement[] = {
                "drop table serie if exists",
                "create table serie(id serial, nom varchar(255), auteur varchar(255), resume varchar(255))",
                "insert into serie(nom, auteur, resume) values ('1erFilm','1erAuteur','1erResume')",
                "insert into serie(nom, auteur, resume) values ('2emeFilm','2emeAuteur','2emeResume')",
                "insert into serie(nom, auteur, resume) values ('3emeFilm','3emeAuteur','3emeResume')",
        };

        System.out.println("------------------------------------  Requête  ------------------------------");
        Arrays.asList(sqlStatement).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println("------------------------------------  Affichage de toutes les séries  ------------------------------------");
        jdbcTemplate.query("select * from serie", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet serie, int i) throws SQLException {
                System.out.println("id : "+serie.getString("id") +
                                    " nom: "+serie.getString("nom") +
                                    " auteur: "+serie.getString("auteur")+
                                    " resume: "+serie.getString("resume"));
                return null;
            }
        });

    }
}
