DecisionLineSystem
==================
Team Serenity Group project for CS509



Instructions for use:

1) Our client went through extensive integration testing with Team Ramrod's server, so I think both groups would prefer running together if possible. The IP address and port number can be specified through command line arguments if needed, but it may be easier to change in the code just to be safe. The code is located in ClientLauncher.java under the default package.

2) Run the client by pressing the "Start" button in Eclipse and wait for it to connect to the server. Once the client is connected, you should see some XML messages being echoed to the console (connectRequest/Response)

3) When the client is connected, the moderator can now create an event. To do this, click "Moderator" on the main form that appears.

4) On the new form that appears, you will be able to enter your question, number of choices and rounds, and specify the type of event and mode of gameplay.
	- Currently all event types and modes are supported

5) When you are finished setting the event options, press the "Create this Event" button.

6) A form asking you to sign in to the event will appear next. Enter your username (required) and password (optional) and press "Sign-In" to continue.

7) Now the "Add Choice" form will appear. Enter a choice into the text box and press the "Add" button. When you are finished entering choices, the "Done" button will be enabled. Press it begin your Decision Lines Event.