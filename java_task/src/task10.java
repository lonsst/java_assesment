import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ДД.ММ.ГГ: ");
        String inputDate = scanner.nextLine();

        int weekNumber = getWeekNumber(inputDate);
        System.out.println("Неделя " + weekNumber);

        scanner.close();
    }

    public static int getWeekNumber(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate date = LocalDate.parse(inputDate, formatter);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
        return weekNumber;
    }
}
