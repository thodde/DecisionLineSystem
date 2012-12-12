DecisionLineSystem
==================
Team Serenity Group project for CS509


Preface:
Our client went through extensive integration testing with Team Ramrod's server, so I think both groups would prefer running together if possible. 



Instructions for Creating an Event (Moderator):

1) The IP address and port number can be specified through command line arguments if needed, but it may be easier to change in the code just to be safe. The code is located in ClientLauncher.java under the default package.

2) Run the client by pressing the "Start" button in Eclipse and wait for it to connect to the server. Once the client is connected, you should see some XML messages being echoed to the console (connectRequest/Response)

3) When the client is connected, the moderator can now create an event. To do this, click "Moderator" on the main form that appears.

4) On the new form that appears, you will be able to enter your question, number of choices and rounds, and specify the type of event and mode of gameplay.
	- Currently all event types and modes are supported

5) When you are finished setting the event options, press the "Create this Event" button.

6) A form asking you to sign in to the event will appear next. Enter your username (required) and password (optional) and press "Submit Credentials" to continue.

7) The "Add Choice" form will appear. Enter a choice into the text box and press the "Add Item" button. When you are finished entering choices, the "Submit" button will be enabled. Press it begin your Decision Lines Event.


Instructions for Signing into an Event as a User:

1) Run the client

2) Copy the event id from the console (You may have to switch back to the console that was populated from the Moderator, this is also assuming that you are running multiple clients on the same machine) and paste it in the event ID box.
	Example console output for the line you are looking for:
		id:c43c58e3-54ec-42f7-8b2a-2ff4eba59471

3) Click "User" and then enter your credentials into the form that appears.
	Note: If you enter the same credentials as a user that already exists in the event, you will not be joined into anything and you will remain on the main form.

4) If the event is open, enter your choice, otherwise (the event is closed), you will be brought directly to the Decision Lines Event where you can proceed.


