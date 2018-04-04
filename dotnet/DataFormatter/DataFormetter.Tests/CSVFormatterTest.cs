using System;
using DataFormatter;
using DataFormatter.Common;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace DataFormetter.Tests
{
    [TestClass]
    public class CSVFormatterTest
    {
        private readonly Mock<IDataService> _dataServiceMock = new Mock<IDataService>();
        [TestMethod]
        public void TestCsv()
        {
            CSVFormatter t = new CSVFormatter(_dataServiceMock.Object);
            var dummyItems = DataService.CreateDummyItems();
            _dataServiceMock.Setup(d => d.ReadData()).Returns(dummyItems);

            t.Execute();
            _dataServiceMock.Verify(d => d.OpenConnection(), Times.Once);

            string expectedText = getExpectedFormat();
            _dataServiceMock.Verify(d => d.ExportData(expectedText), Times.Once);
            _dataServiceMock.Verify(d => d.CloseConnection(), Times.Once);
        }

        private String getExpectedFormat()
        {
            return "1, First Test item, 100\n" +
            "2, second Test item, 210\n" +
            "3, third Test item, 200\n" +
            "4, fourth Test item, 300\n";
        }
    }
}
