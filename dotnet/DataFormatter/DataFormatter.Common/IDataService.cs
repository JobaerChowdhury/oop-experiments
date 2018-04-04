using System;
using System.Collections.Generic;

namespace DataFormatter.Common
{
    public interface IDataService
    {
        void OpenConnection();
        List<Item> ReadData();
        bool ExportData(String exportedData);
        void CloseConnection();
        void NotifyJobComplete();
    }
}