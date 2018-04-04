using System;
using System.Collections.Generic;

namespace DataFormatter.Common
{
    public class DataService : IDataService
    {
        private bool _connectionStatus = false;

        public void OpenConnection()
        {
            if (_connectionStatus)
                throw new InvalidOperationException("Connection is already open");

            _connectionStatus = true;
        }

        public List<Item> ReadData()
        {
            if (!_connectionStatus)
            {
                throw new InvalidOperationException("Must open the connection first");
            }

            return CreateDummyItems();
        }

        public bool ExportData(String exportedData)
        {
            Console.WriteLine("Exporting following data to some file...");
            Console.WriteLine(exportedData);
            return true;
        }

        public void CloseConnection()
        {
            _connectionStatus = false;
        }

        public void NotifyJobComplete()
        {
            Console.WriteLine("Job is complete");
        }

        public static List<Item> CreateDummyItems()
        {

            return new List<Item>
            {
                new Item {Id="1",Title = "First Test item",Value= 100},
                new Item {Id="2",Title = "second Test item",Value= 210},
                new Item {Id="3",Title = "third Test item",Value= 200},
                new Item {Id="4",Title = "fourth Test item",Value= 300},
            };
        }

    }
}
