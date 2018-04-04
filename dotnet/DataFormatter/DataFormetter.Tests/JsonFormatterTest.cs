using DataFormatter;
using DataFormatter.Common;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using Newtonsoft.Json;

namespace DataFormetter.Tests
{
    [TestClass]
    public class JsonFormatterTest
    {
        private readonly Mock<IDataService> _dataServiceMock = new Mock<IDataService>();

        [TestMethod]
        public void TestJson()
        {
            JsonFormatter formatter = new JsonFormatter(_dataServiceMock.Object);
            var dummyItems = DataService.CreateDummyItems();
            _dataServiceMock.Setup(d => d.ReadData()).Returns(dummyItems);
            formatter.Execute();

            _dataServiceMock.Verify(d => d.OpenConnection(), Times.Once);
            _dataServiceMock.Verify();
             var expectedJsonString = JsonConvert.SerializeObject(dummyItems);
            //_dataServiceMock.Verify(d => d.ExportData(expectedJsonString), Times.Once);

            var argumentCaptor = new ArgumentCaptor<string>();
            _dataServiceMock.Verify(h => h.ExportData(argumentCaptor.Capture()));
            var values = argumentCaptor.Value;
            Assert.AreEqual(expectedJsonString,values);
            _dataServiceMock.Verify(d => d.CloseConnection(), Times.Once);
        }
       
    }
}
