package algorithms;

import utils.PrintUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayListBuildInSort {
    PrintUtils printUtils = new PrintUtils();
    ArrayList table = new ArrayList<Integer>();

    public String arrayListBuildInSort() {
        initTable();

        Instant start = Instant.now();
        buildInSort();
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillisPart();

        return printUtils.createOutput("Build in natural order for arrayList", timeElapsed, table.size(), table);
    }

    void buildInSort(){
        table.sort(Comparator.naturalOrder());
    }

    void initTable() {
        int i = 10000;
        while (i-- > 0) {
            Integer randomNum = (Integer) ThreadLocalRandom.current().nextInt(1, 1000 + 1);
            table.add(randomNum);
        }
    }

}
