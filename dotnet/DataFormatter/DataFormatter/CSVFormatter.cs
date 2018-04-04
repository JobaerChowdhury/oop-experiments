using System;
using System.Collections.Generic;
using System.Text;
using DataFormatter.Common;

namespace DataFormatter
{
    public class CSVFormatter
    {
        private readonly IDataService _dataService;

        public CSVFormatter(IDataService dataService)
        {
            this._dataService = dataService;
        }

        public bool Execute()
        {
            try
            {
                _dataService.OpenConnection();
                var items = _dataService.ReadData();
                var formattedData = formatData(items);
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
         * Returns a csv format from the list of items.
         * First the id, then the title and then the value.
         * All the properties separated by comma. And after every item a new line.
         *
         * @param items The list of items
         * @return A string with proper csv format
         */
        private String formatData(List<Item> items)
        {
            //        todo this method needs to be implemented
            //        throw new RuntimeException("Todo");
            return dummyImpl(items);
        }

        private String dummyImpl(List<Item> items)
        {
            StringBuilder stringBuilder = new StringBuilder();
            foreach (var item in items)
            {
                stringBuilder
                    .Append(item.Id).Append(", ")
                    .Append(item.Title).Append(", ")
                    .Append(item.Value)
                    .Append("\n");
            }
            return stringBuilder.ToString();
        }
    }
}
