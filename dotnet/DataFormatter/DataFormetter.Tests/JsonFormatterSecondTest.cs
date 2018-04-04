using System.Threading;
using DataFormatter;
using DataFormatter.Common;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace DataFormetter.Tests
{
    [TestClass]
    public class JsonFormatterSecondTest
    {
        private readonly Mock<IDataService> _dataServiceMock = new Mock<IDataService>();

        [TestMethod]
        public void TestNotifyJobComplete()
        {
            JsonFormatter formatter = new JsonFormatter(_dataServiceMock.Object);
            formatter.Execute();
            _dataServiceMock.Setup(d => d.NotifyJobComplete())
                .Callback(() => Thread.Sleep(1000));
            _dataServiceMock.Object.NotifyJobComplete();
        }
    }
}
