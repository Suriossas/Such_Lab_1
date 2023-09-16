import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public double a = 2;
    public double b = -3;
    public double x = 0.1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    /* Расчёт первой функции */
    public static double CalculateFunction1(double a, double b, double x){
        var f_ = a * Math.pow(Math.cos(x), 3);
        var g_ = Math.abs(b * Math.tan(Math.sqrt(x)));
        return f_ - g_;
    }
    /* Расчёт второй функции */
    public static double CalculateFunction2(double a, double b, double x){
        var v_ = Math.log10(Math.pow(x - b, 3));
        return a * x / Math.pow(v_, 2);
    }

    public void GetValues(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите значения для переменной a:");
        this.a = TryGetValue(scanner.next());
        System.out.print("Укажите значения для переменной b:");
        this.b = TryGetValue(scanner.next());
        System.out.print("Укажите значения для переменной x:");
        this.x = TryGetValue(scanner.next());
    }
    public void ShowResults(){
        System.out.format("Результат первой функции %f", CalculateFunction1(this.a,this.b, this.x)).println();
        System.out.format("Результат второй функции %f", CalculateFunction2(this.a,this.b, this.x)).println();
    }
    public void ShowValues(){
        System.out.format("a = %f", this.a).println();
        System.out.format("b = %f", this.b).println();
        System.out.format("x = %f", this.x).println();
    }
    public void ShowMenu(){
        String[] menu_l = new String[] {
                "1 - Ввод значений",
                "2 - Вывод значений",
                "3 - Расчёт и вывод значений",
                "4 - Вывод текущей даты и времени",
                "5 - ❌ Выход из программы"
        };
        Log.Add("Меню:");
        for (String val : menu_l) { Log.Add(val); }

        var selected_index = (new Scanner(System.in)).nextInt();
        switch (selected_index) {
            case 1: GetValues(); break;
            case 2: ShowValues(); break;
            case 3: ShowResults(); break;
            case 4: ShowDateTime(); break;
            case 5: return;
            default: Log.Add("Значение должно быть от 1 до 5");
        }
        ShowMenu();
    }
    public void ShowDateTime() {
        final var datetime = new Date();
        System.out.format("Текущая дата и время: %s", dateFormat.format(datetime)).println();
    }

    public double TryGetValue(String value){
        value = value.replace(',', '.');
        return Double.parseDouble(value);
    }

    public static void main(String[] args) {
        Log.Add("Программа успешно запущена");
        Main main = new Main();
        main.ShowValues();
        main.ShowMenu();
        Log.Add("Работа с программой окончена");
    }
}