package com.cefalo.oopcourse.experiment;

import java.util.Arrays;
import java.util.List;

/**
 * A basic data service class.
 */
public class DataService {
    private boolean connectionStatus = false;

    public void openConnection() throws Exception {
        if (connectionStatus) throw new IllegalStateException("Connection is already open");

        connectionStatus = true;
    }

    public List<Item> readData() throws Exception {
        if (!connectionStatus) {
            throw new IllegalStateException("Must open the connection first");
        }

        return createDummyItems();
    }

    public boolean exportData(String exportedData) {
        System.out.println("Exporting following data to some file...");
        System.out.println(exportedData);
        return true;
    }

    public void closeConnection() {
        connectionStatus = false;
    }

    public void notifyJobComplete() {
        System.out.println("Job is complete");
    }

    static List<Item> createDummyItems() {
        return Arrays.asList(
                createItem("1", "First Test item", 100.0),
                createItem("2", "second Test item", 210.0),
                createItem("3", "third Test item", 200.0),
                createItem("4", "fourth Test item", 300.0)
        );
    }

    private static Item createItem(String id, String title, double value) {
        return new Item(id, title, value);
    }
}
