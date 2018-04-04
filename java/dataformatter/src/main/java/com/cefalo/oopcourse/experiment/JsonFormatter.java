package com.cefalo.oopcourse.experiment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * Basic json formatter
 */
public class JsonFormatter {
    private DataService dataService;

    public JsonFormatter(DataService dataService) {
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
     * Returns a String json format from the list of items.
     * It should be something like following -
     * {
     * "result": [
     * {
     * "id": "1",
     * "title": "item 1",
     * "value": 100.0
     * }, {
     * "id": "2",
     * "title": "item 2",
     * "value": 120.0
     * }
     * ]
     * }
     *
     * @param items The list of items
     * @return A string with proper csv format
     */
    private String formatData(List<Item> items) throws JsonProcessingException {
        //todo Implement this
//        JsonUtil.fromItemList(items)
        throw new RuntimeException("todo");
    }

    public static void main(String[] args) {
        DataService dataService = new DataService();
        JsonFormatter formatter = new JsonFormatter(dataService);

        boolean execute = formatter.execute();
        System.out.println("status = " + execute);

    }
}
