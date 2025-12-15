package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogTransacoes {

    private static final String ARQUIVO = "transacoes.csv";

    public static void registrar(int id, String operacao) {

        try {
            File file = new File(ARQUIVO);

            // Se não existir, cria e escreve o cabeçalho
            if (!file.exists()) {
                FileWriter fw = new FileWriter(file);
                fw.write("ID;TIPO_OPERACAO;DATA_HORA\n");
                fw.close();
            }

            FileWriter fw = new FileWriter(file, true);

            String dataHora = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            fw.write(id + ";" + operacao + ";" + dataHora + "\n");
            fw.close();

        } catch (IOException e) {
            System.out.println("Erro ao gravar log de transações");
            e.printStackTrace();
        }
    }
}
