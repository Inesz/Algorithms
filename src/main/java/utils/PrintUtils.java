package utils;

public class PrintUtils {
    public String createOutput(String algorithm, long time, int length, Object content) {
        return String.format("%-50s Time: %10d ms, Elements number: %10d, Table: %s", algorithm, time, length, content.toString());
    }
}
