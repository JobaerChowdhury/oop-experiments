using System;
using System.Collections.Generic;
using DataFormatter.Common;
using Newtonsoft.Json;

namespace DataFormatter
{
    public class JsonFormatter
    {
        private readonly IDataService _dataService;

        public JsonFormatter(IDataService dataService)
        {
            this._dataService = dataService;
        }

        public bool Execute()
        {
            try
            {
                _dataService.OpenConnection();

                var items = _dataService.ReadData();

                String formattedData = FormatData(items);

                return _dataService.ExportData(formattedData);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                _dataService.CloseConnection();
            }

            return false;
        }

        /**
         * Returns a String json format from the list of items.
         * It should be something like following -
         * {
         * [
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
        private String FormatData(List<Item> items)
        {
            return JsonConvert.SerializeObject(items);
        }
    }
}
