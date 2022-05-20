import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < source.size(); i++) {
            Integer element = source.get(i);
            if (element <= threshold) {
                result.add(element);
                logger.log("Элемент \"" + element + "\" проходит");
                count++;
            } else {
                logger.log("Элемент \"" + element + "\" не проходит");
            }
        }
        logger.log(" Прошло фильтр " + count + " элемента из " + source.size());
        return result;
    }
}

