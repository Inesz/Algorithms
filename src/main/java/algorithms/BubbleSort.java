package algorithms;

import utils.PrintUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleSort {
    PrintUtils printUtils = new PrintUtils();

    ArrayList table = new ArrayList<Integer>();

    public String bubbleSortExecutor() {
        initTable();

        Instant start = Instant.now();
        bubbleSort();
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillisPart();

        return printUtils.createOutput("Bubble Sort", timeElapsed, table.size(), table);
    }

    void bubbleSort() {
        int n = table.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((Integer) table.get(j) > (Integer) table.get(j + 1)) {
                    Integer temp = (Integer) table.get(j);
                    table.set(j, (Integer) table.get(j + 1));
                    table.set(j + 1, temp);
                }
            }
        }
    }

    void initTable() {
        int i = 10000;
        while (i-- > 0) {
            Integer randomNum = (Integer) ThreadLocalRandom.current().nextInt(1, 1000 + 1);
            table.add(randomNum);
        }
    }
}
