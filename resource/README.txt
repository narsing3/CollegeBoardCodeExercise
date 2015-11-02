@Author: Narsing M Lingala
@CollegeBoard Code Test



README.txt for NumberGuesser App.
*********************************

There are eight files in total(six .java files, one log4j.properties and one readme.txt file). in the code base for Number Guesser. 
1. NumberGuesserMain.java -> The main class which can be used to test the application. This class sets the search bean and starts the game when user says READY.
2. NumberGuesserService.java -> It actually does the binary search. Motheds are modularised to test.
3. NumberGuesserUtils.java -> It provided reusable utils used across the app both for service and in tests.
4. BinarySearchBean.java -> The bean is a simple value Object to encapsulate the search details.
5. Constants.java -> Contains the constans assumed and used across the app. It avoids hardcoding.
6. NumberGuesserServiceTest.java -> Contains a testcase to test BinarySearch implemented. Additional testcases can be added if needed as the test framework setup is ready.
7. log4j.properties file sets the log levels for application and test classes.
8. This readme.txt file with notes.


assumptions and workflow:
1. Assuming the number range from 0 to 1000. 
2. Game starts when user says READY. Quits when said END.
3. The search calculates the Max possible valid search iterations in binary search to be O(log N). If Exceeded, the game exists with a message to the user that the user responses were not consistent and to start the game again there by avoiding running is loops due to inconsistent responses (Eg:- If the user changes the guess in thr middle of the game ).
4. Used Scannner class instead of complex Buffered Streams for simple user response gathering.
5. Iteration used instead of stackframe oriented recursion.
6. Created junit testcases for testable service methods to confirm the binary search implementation.
7. Invalid responses from the user are validated and informed with messages on console. User will see the gueesed number and can say YES to end the game or can quit the game by saying END. 
8. A validation is in place to identify that if the valid attempts are more than O(log N), the game ends with appropriate message to the user.