package algorithms;

import utils.PrintUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class InsertionSort {
    PrintUtils printUtils = new PrintUtils();

    ArrayList table = new ArrayList<Integer>();
    int size = 100;

    public InsertionSort(String text) {
        if (text != null && !text.equals("")) {
            size = Integer.parseInt(text);
        }
    }

    public String insertionSortExecutor() {
        initTable();

        Instant start = Instant.now();
        insertionSort();
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillisPart();

        return printUtils.createOutput("Insertion Sort", timeElapsed, table.size(), table);
    }

    private void insertionSort() {
        int n = table.size();

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && (Integer) table.get(j) > (Integer) table.get(i)) {
                j = j - 1;
            }
            table.add(j + 1, table.get(i));
            table.remove(i + 1);
        }
    }

    void initTable() {
        int s = size;
        while (s-- > 0) {
            Integer randomNum = (Integer) ThreadLocalRandom.current().nextInt(1, size + 1);
            table.add(randomNum);
        }
    }
}
