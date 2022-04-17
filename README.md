## Prerequites
Install Java Development Kit (Latest 1.8)


Add JDK to $PATH


Install Appache Maven


Add Maven to $PATH



Create a file called "Configuration.properties" in the configs folder.  
Add your own values to the keys:

url = URL TO BE TESTED i.e. http://localhost:3000   
eyes_token = Applitools Eyes API Token   
btnAbsPath = The ABSOLUTE path to pageObjects/Capture1.PNG   
  

To run the test:
mvn verify test -Dbrowser=chrome

The first time the test runs, the test will fail as there is no baseline image stored in Applitools.  After first run,
launch applitools and selecting a floating area for the sprite to move.  Set the small square to the sprite and large square to viewport.
Save and rerun test.

Tests will now pass.

To test the implementation, change the background colour of the canvas after click.  The test will now fail because of
the difference in colour to the baseline image.
