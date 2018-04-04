package com.cefalo.oopcourse.experiment;

import java.util.List;

/**
 * Basic csv formatter
 */
public class CSVFormatter {
    private DataService dataService;

    public CSVFormatter(DataService dataService) {
        this.dataService = dataService;
    }

    public boolean execute() {
        try {
            dataService.openConnection();

            List<Item> items;
            items = dataService.readData();

            String formattedData = formatData(items);

            return dataService.exportData(formattedData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataService.closeConnection();
        }

        return false;
    }

    /**
     * Returns a csv format from the list of items.
     * First the id, then the title and then the value.
     * All the properties separated by comma. And after every item a new line.
     *
     * @param items The list of items
     * @return A string with proper csv format
     */
    private String formatData(List<Item> items) {
//        todo this method needs to be implemented
        throw new RuntimeException("Todo");
    }

    public static void main(String[] args) {
        DataService dataService = new DataService();
        CSVFormatter textFormatter = new CSVFormatter(dataService);

        boolean execute = textFormatter.execute();
        System.out.println("status = " + execute);

    }
}
