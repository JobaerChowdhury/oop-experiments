# Problem Summary #
In this problem you'll be working with a simple export system. There is an existing `DataService` api
  which you can call to get a list of `Items`. And your taks would be to format the list of items
  in two different ways - `csv` and `json`. (`Items` are plain objects with three properties - id,
  title and a string value.)

The `DataService` api is a stateful api. You need to first open the connection, and then call
  `readData` for reading the items. After reading the items you need to convert them in a string
   representation, and call the `exportData` method with that formatted string.
   Afterwards you must close the connection.

So a very basic workflow would be like following.

```java
try {
        dataService.openConnection();

        List<Item> items = dataService.readData();

        String formattedData = formatData(items);

        return dataService.exportData(formattedData);

    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        dataService.closeConnection();
    }
```

Your task would be to implement the `formatData(List<Item> items)` method. First for `csv` and then for `json`.

Fortunately you'll be working against some existing test cases written by the CTO. So after each step you can verify
  that your implementation is correct. __You can read the test cases but must not modify them, because modifying
  them might get you kicked out from the team.__

### Prerequisite ###
* Make sure you have java installed
* Make sure you have maven installed
* Preferably you should also have an IDE for edit code

## Lab works ##
So fire up the IDE and start writing some code :-)

### Step 0: Set everything up ###
* Make sure your project setup is complete, and you are comfortable with modify-compile-run workflow.

### Step 1: Format in csv style ###
1. Run the `CSVFormatterTest` and make sure the `testCsv` method is failing. You will make
it pass soon, so don't worry :-)
2. If you briefly look into the error message you'll notice that the `CSVFormatter.formatData`
method throws a `RuntimeException`. Open the `CSVFormatter` class and you can verify
 that indeed it's throwing an exception. You have to implement the method `formatData`.
3. Implementing the `formatData` method should be easy. Just iterate the list of items,
 and append them with comma and newline at appropriate places.
4. Make sure the test case `CSVFormatterTest` is running successfully now.


### Step 2: Format in Json style ###
Now that you have a formatter for csv format, new requirements arrive for having a json format.
Your next task would be to implement the json format. Let's do that.

1. Run the `JsonFormatterTest` and make sure the `testJson` method fails.
2. Like before you can now open the `JsonFormatter` class and implement the `formatData` method.
3. If you are comfortable with json handling you can try implementing it by your own, just follow the javadoc/comments
above the method. For your convenience we also provided a `JsonUtil` class. So you can also use the `fromItemList`
method directly, instead of your own version.
4. Make sure the `JsonFormatterTest.testJson` can run successfully now.

### Step 3: Minimize duplicate code ###
Ok, so now you have two formatter working flawlessly. You should be very happy. But you may feel that something isn't quite
right. If you compare the `JsonFormatter` and the `CSVFormatter` you can see they share an awful lot
of code. And we know code duplication is nasty, especially if you have to maintain the code for a long
time. So roll up your sleeves, and start reducing the ugly duplicate code.

1. Try your best to make the `JsonFormatter` and `CSVFormatter` share as much code as possible.
2. After you are happy run both the test cases and make sure everything is fine.

### Step 4: Change is the only constant in software development ###
You should be very proud of your last attempt. Since you have removed all the duplicate code while still keeping everything
fine. And made the CTO very happy!

But good days doesn't last long. As usual the requirement for the business **slightly** changed.
So now you have the following condition to satisfy.

> After the json formatter has exported the data, it should notify the DataService api, by calling notifyJobComplete method.

So you have to call the `DataService.notifyJobComplete` after you call the
`DataService.exportData` method.

Yes, **only** for the json format. The csv format should remain same. Wat!

1. Run the `JsonFormatterSecondTest` and make sure the testcase fails. This test case verifies
 that the `notifyJobComplete` method is called after the json processing.
2. Keeping as much re-usable code as possible, implement this functionality.
3. Make sure all the test cases are run successfully.
