# Problem Summary #
In this problem we'll be working with a simple export system. We have an existing `DataService` api
  which we can call to get a list of `Items`. And our taks would be to format the list of items
  in two different ways - `csv` and `json`. (`Items` are plain objects with three properties - id,
  title and a string value.)

The `DataService` api is a stateful api. We need to first open the connection, and then call
  `readData` for reading the items. After we read the items we have to convert them in a string
   representation, and call the `exportData` method with that formatted string. Afterwards we must close the connection.

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

Our task would be to implement the `formatData(List<Item> items)` method. Once for `csv` and again for `json`.

Fortunately we'll be working against some existing test cases written by our CTO. So after each step we can verify
  that our implementation is correct. __We can read the test cases but must not modify them, because modifying
  them might get us kicked out from the team.__

### Prerequisite ###
* Make sure you have java installed
* Make sure you have maven installed
* Preferably you should also have an IDE for edit code

## Lab works ##
So let's fire up the IDE and start writing some code :-)

### Step 0: Set everything up ###
* Make sure your project setup is complete, and you are comfortable with modify-compile-run workflow.

### Step 1: Format in csv style ###
1. Run the `CSVFormatterTest` and make sure the `testCsv` method is failing. We will make
it pass soon, so don't worry :-)
2. If we briefly look into the error message we'll notice that the `CSVFormatter.formatData`
method throws a `RuntimeException`. Let's open the `CSVFormatter` class and we can verify
 that indeed it's throwing an exception. We have to implement the method.
3. Implementing the `formatData` method should be easy. Just iterate the list of items
and append then with comma and newline at appropriate places.
4. Make sure the test case is running successfully now.


### Step 2: Format in Json style ###
Now that we have a formatter for csv format, new requirements arrive for having a json format.
Our next task would be to implement the json format. Let's do that. Yes, we can hardly wait, json is cool!

1. Run the `JsonFormatterTest` and make sure the `testJson` method fails.
2. Like before we can now open the `JsonFormatter` class and implement the `formatData` method.
3. If you are comfortable with json handling you can try implementing it by your own, just follow the javadoc/comments
above the method. For your convenience we also provided a `JsonUtil` class. So you can also use the `fromItemList`
method directly, instead of your own version.
4. Make sure the `JsonFormatterTest.testJson` can run successfully now.

### Step 3: Minimize duplicate code ###
Ok, so now we have our two formatter working flawlessly. We are very happy. But something doesn't feel quite
right. If we compare the `JsonFormatter` and the `CSVFormatter` we can see they share an awful lot
of common code. And we know code duplication is nasty, if we have to maintain the code for a long
time. So let's roll up our sleeves, and start reducing the ugly duplicate code.

1. Try your best to make the `JsonFormatter` and `CSVFormatter` share as much code as possible.
2. After you are happy run both the test cases and make sure everything is fine.

### Step 4: Change is the only constant in software development ###
We were very proud of our last attempt. We have removed all the duplicate code while still keeping everything
fine. And made our CTO very happy!

But good days doesn't last long. As usual the requirement for the business **slightly** changed.
So now we have the following condition to satisfy.

> After the json formatter has exported the data, it should notify the DataService api.

So we have to call the `DataService.notifyJobComplete` after we call the
`DataService.exportData` method.

Yes, **only** for the json format. The csv format should remain same. Wat!

1. Run the `JsonFormatterSecondTest` and make sure the testcase fails. This test case verifies
 that the `notifyJobComplete` method is called after the json processing.
2. Keeping as much re-usable code as possible, implement this functionality.
3. Make sure all the test cases are run successfully.














