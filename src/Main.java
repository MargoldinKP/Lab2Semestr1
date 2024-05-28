import java.util.Scanner;
public class Main
{
    // Метод для подсчета кол-ва цифр в числе:
    public static int countDigits(int number)
    {
        int count = 0;
        while (number != 0)
        {
            number /= 10;
            count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите последовательность чисел (через пробел): ");
        String input = scanner.nextLine();
        Scanner numberScanner = new Scanner(input);

        // Инициализируем переменные:
        int maxdigitCount = 0;
        int minNumber = Integer.MAX_VALUE;

        // Перебираем числа в последовательности, с помощью метода сканнера возвращая true, false:
        while (numberScanner.hasNext())
        {
            // Считываем следующее число как строку:
            String numberStr = numberScanner.next();

            // Преобразуем строку в целое число с помощью метода Integer.parseInt:
            int number = Integer.parseInt(numberStr);
            // Считаем количество цифр в текущем числе:
            int digitCount = countDigits(number);

            // Проверка имеет ли текущее число больше цифр чем текущий max(если кол-во цифр одинаково, проверяем по значению)
            if (digitCount > maxdigitCount | (digitCount == maxdigitCount && number < minNumber))
            {
                maxdigitCount = digitCount;
                minNumber = number;
            }
        }

        // Результат:
        System.out.println("Минимальное число с максимальным количеством цифр: " + minNumber);
    }
}