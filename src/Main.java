import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void printDependents(String name) {
        // Получение данных с сайта pypi.org
        String url = "https://pypi.org/pypi/" + name + "/json";

        // Создание объекта для работы с сайтом
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Получение данных с сайта
        String data = null;
        try {
            assert connection != null;
            data = new String(connection.getInputStream().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Поиск зависимостей
        System.out.println("Зависимости для " + name + ":");
        System.out.println(data);

        // Преобразовать строку ответа в объект JSON
//        try {
//            JSONObject json = new JSONObject(data);
//
//            // Получить объект с информацией о пакете
//            JSONObject info = json.getJSONObject("info");
//
//            // Получить список зависимостей
//            JSONArray requiresDist = info.getJSONArray("requires_dist");
//
//            // Вывести список зависимостей
//            for (int i = 0; i < requiresDist.length(); i++) {
//                String require = requiresDist.getString(i);
//                System.out.println(require);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        /*
            Написать на выбранном вами языке программирования программу, которая принимает в качестве аргумента
            командной строки имя пакета, а возвращает граф его зависимостей в виде текста на языке Graphviz. На
            выбор: для npm или для pip. Пользоваться самими этими менеджерами пакетов запрещено. Главное, чтобы
            программа работала даже с неустановленными пакетами и без использования pip/npm.
         */

        // Проверка на наличие аргумента
        if (args.length == 0) {
            System.out.println("Не указан аргумент");
            return;
        }

        printDependents(args[0]);

    }
}