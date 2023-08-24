Projeto usando Java 20, para realização da leitura de um Arquivo
TXT com dados separados por vírgula, e retornar na saída o Log com um JSON.

O arquivo encontra-se em src/main/resources.

# Para executar via jar, faça:

```bash
./mvnw clean package
```

Após isso, execute:

```bash
java -jar target/read-csv-file-1.0.0-jar-with-dependencies.jar
```
A saída será parecida com essa:

```console
❯ java -jar target/read-csv-file-1.0.0-jar-with-dependencies.jar
ago. 24, 2023 8:35:49 AM CsvReader lambda$main$0
INFORMAÇÕES: { name='Robin', endereco='New Park Street', city='NewYork'}
ago. 24, 2023 8:35:49 AM CsvReader lambda$main$0
INFORMAÇÕES: { name='Tim', endereco='New Park Street', city='Paris'}
ago. 24, 2023 8:35:49 AM CsvReader lambda$main$0
INFORMAÇÕES: { name='Stuwart', endereco='New Park Street', city='London'}
ago. 24, 2023 8:35:49 AM CsvReader lambda$main$0
INFORMAÇÕES: { name='Craig', endereco='New Park Street', city='Tokyo'}
ago. 24, 2023 8:35:49 AM org.example.db.ConnectionManager createConnection
INFORMAÇÕES: Conexão com o SQL Lite estabelecida. null
ago. 24, 2023 8:35:49 AM org.example.db.PersonDAO save
INFORMAÇÕES: Dados da Pessoa: { name='Robin', endereco='New Park Street', city='NewYork'} foram inseridos com sucesso.
ago. 24, 2023 8:35:49 AM org.example.db.PersonDAO save
INFORMAÇÕES: Dados da Pessoa: { name='Tim', endereco='New Park Street', city='Paris'} foram inseridos com sucesso.
ago. 24, 2023 8:35:49 AM org.example.db.PersonDAO save
INFORMAÇÕES: Dados da Pessoa: { name='Stuwart', endereco='New Park Street', city='London'} foram inseridos com sucesso.
ago. 24, 2023 8:35:49 AM org.example.db.PersonDAO save
INFORMAÇÕES: Dados da Pessoa: { name='Craig', endereco='New Park Street', city='Tokyo'} foram inseridos com sucesso.
```