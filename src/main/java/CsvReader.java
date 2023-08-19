import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.example.db.ConnectionManager;
import org.example.db.PersonDAO;
import org.example.java.domain.Person;

/**
 * Hello world!
 *
 */
public class CsvReader {
    static final Logger LOGGER = Logger.getLogger(CsvReader.class.getName());

    /**
     * @param args
     */
    public static void main(String[] args) {
        Path diretorioAtual = Paths.get("src/main/resources/");
        String caminhoAbsoluto = diretorioAtual.toAbsolutePath().toString();
        String caminhoArquivoAbsoluto = caminhoAbsoluto + "/persons.txt";
        List<Person> people = load(caminhoArquivoAbsoluto);
        
        people.forEach(p -> LOGGER.info(p.toString()));

        try {
            savePersons(people);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private static List<Person> load(String localizacaoArquivo) {
        List<Person> people = new ArrayList<Person>();

        try (BufferedReader reader = new BufferedReader(new FileReader(localizacaoArquivo))) {
            String linha = reader.readLine();

            while (linha != null) {
                String campos[] = linha.split(",");
                people.add(new Person(campos[0], campos[1], campos[2]));
                linha = reader.readLine();
            }

        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }

        return people;
    }

    private static void savePersons(List<Person> persons) throws SQLException {
        PersonDAO personDAO = new PersonDAO();
        persons.forEach(p -> personDAO.save(p));
        ConnectionManager.closeConnection();
    }
}
