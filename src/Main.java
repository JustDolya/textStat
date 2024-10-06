import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        // Путь к исходному файлу
        String filePath = "src/input.txt";

        // Чтение файла
        String content = readFileAsString(filePath);

        if (content != null) {
            // Подсчет статистики
            int totalCharacters = content.length();
            int charactersWithoutSpaces = content.replace(" ", "").length();
            int wordCount = content.split("\\s+").length;
            int lineCount = content.split("\n").length;
            int paragraphCount = content.split("\n\\s*\n").length;

            // Вывод в консоль
            System.out.println("Количество символов в тексте: " + totalCharacters);
            System.out.println("Количество символов без пробелов: " + charactersWithoutSpaces);
            System.out.println("Количество слов: " + wordCount);
            System.out.println("Количество строк: " + lineCount);
            System.out.println("Количество абзацев: " + paragraphCount);

            // Запись статистики в исходный файл
            writeStatisticsToFile(filePath, totalCharacters, charactersWithoutSpaces, wordCount, lineCount, paragraphCount);
        } else {
            System.out.println("Ошибка при чтении файла.");
        }
    }

    // Чтение файла как строки
    private static String readFileAsString(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Запись статистики в тот же файл
    private static void writeStatisticsToFile(String filePath, int totalChars, int charsWithoutSpaces, int wordCount, int lineCount, int paragraphCount) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);){
            // Открываем файл в режиме добавления (true - для добавления к существующему содержимому)

            // Добавляем разделитель для удобства чтения
            fileWriter.write("\n\n--- Статистика текста ---\n");

            // Записываем данные в файл
            fileWriter.write("Количество символов в тексте: " + totalChars + "\n");
            fileWriter.write("Количество символов без пробелов: " + charsWithoutSpaces + "\n");
            fileWriter.write("Количество слов: " + wordCount + "\n");
            fileWriter.write("Количество строк: " + lineCount + "\n");
            fileWriter.write("Количество абзацев: " + paragraphCount + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}