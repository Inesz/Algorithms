package utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadsMgmt {
    public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
}
