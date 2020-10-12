package controllers;

import algorithms.ArrayListBuildInSort;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.ThreadsMgmt;

public class MainController {
    ThreadsMgmt threadsMgmt = new ThreadsMgmt();

    @FXML
    TextArea console;

    @FXML
    TextField insertionSortSize;

    public void computeBubbleSort(ActionEvent actionEvent) {
        Task<Void> task = new Task() {
            @Override
            protected Object call() throws Exception {
                String output = new BubbleSort().bubbleSortExecutor();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        console.setText(console.getText() + "\n" + output);
                    }
                });

                return null;
            }
        };

        threadsMgmt.executor.execute(task);
    }

    public void computeBuildInSort(ActionEvent actionEvent) {
        Task<Void> task = new Task() {
            @Override
            protected Object call() throws Exception {
                String output = new ArrayListBuildInSort().arrayListBuildInSort();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        console.setText(console.getText() + "\n" + output);
                    }
                });

                return null;
            }
        };

        threadsMgmt.executor.execute(task);
    }

    public void computeInsertionSort(ActionEvent actionEvent) {
        Task<Void> task = new Task() {
            @Override
            protected Object call() throws Exception {
                String output = new InsertionSort(insertionSortSize.getText()).insertionSortExecutor();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        console.setText(console.getText() + "\n" + output);
                    }
                });

                return null;
            }
        };

        threadsMgmt.executor.execute(task);
    }
}
