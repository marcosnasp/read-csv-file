import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.example.java.domain.Person;

/**
 * Hello world!
 *
 */
public class CsvReader 
{
    static final Logger logger = Logger.getLogger(CsvReader.class.getName());    

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Path diretorioAtual = Paths.get("src/main/resources/");
        String caminhoAbsoluto = diretorioAtual.toAbsolutePath().toString();
        String caminhoArquivoAbsoluto = caminhoAbsoluto + "/persons.txt";
        List<Person> people = load(caminhoArquivoAbsoluto);
        for (Person person : people) {
            logger.info(person.toString());
        }
    }

    private static List<Person> load(String localizacaoArquivo) {
        List<Person> people = new ArrayList<Person>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(localizacaoArquivo));
            try {
                String linha = reader.readLine();

                while(linha != null) {
                    String campos[] = linha.split(",");
                    people.add(new Person(campos[0], Integer.parseInt(campos[1]), campos[2]));
                    linha = reader.readLine();
                }
            } catch (IOException e) {
                logger.info(e.getMessage());
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }

        return people;
    }
}
