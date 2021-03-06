package start;

import reader.TxtFileReader;
import word.WordUnit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        ArrayList<WordUnit> list = new ArrayList<WordUnit>();

        //args[0] - путь к читаемому файлу у меня  - C:\Users\Smela\IdeaProjects\Seminar-3\src\resources\test.txt
        TxtFileReader.readFile(args[0], map);

        WordUnit wordUnit = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordUnit = new WordUnit(entry.getKey(), entry.getValue());

            list.add(wordUnit);
        }
        //compareTo написан в WordUnit, Сначала сортирует по колличесву совпадений, потом досортировывает ликсикографически
        Collections.sort(list, WordUnit::compareTo);

        for (WordUnit unit : list) {
            System.out.println(unit.toString());
        }
    }
}
