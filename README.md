                                              Rai's and Luo's Pacman Game

Compiling and Run Instructions
1. Compile and run Game.java from the master branch.
2. Once you run Game.java, the game will start. 

Usage Instructions
1. Use the arrow keys to control Pacman. The up arrow key makes Pacman go up, the down arrow key makes Pacman go down, the right arrow key makes Pacman go right, and the left arrow key makes Pacman go left.
2. Run Pacman into a ghost, and Pacman will lose one life. Pacman has a total of 3 lives. Once you lose all three lives, you lose the game. Then, you will be given the option of restarting the game or exiting.
3. If Pacman eats one of the four power pellets (the oversized pac-dots that are located in each corner of the maze), the ghosts will go into "Blue-Mode" for seven seconds which means that they will be eaten by Pacman if they run into each other. In addition, your score increases by 20 points. 
4. Have Pacman eat all of the dots (without touching a ghost) in order to win the game. Each time Pacman eats one of the dots, the score (displayed under the maze) increases by 1. Each time Pacman eats one of the Power Pellets, the score increases by 20.
5. If you win the game, you will be given an option to exit the game or restart the game.

Development Log
Jan 5/ Jan 6: We were experimenting with basic GUI, trying to figure out how to set up the grid for the game and how to make the walls for the maze. We were also experimenting with how to label certain parts of the grid with images (Pacdots, Pacman, Blinky, Inky, Clyde...etc).

Jan 7: We were able to set up the grid layout for the project and put Pacman onto the grid, scaling the image to an appropriate size for the grid. We also set the color of the background to black, and we kept experimenting with how to make the walls for the maze.
          
Jan 8: Major issue in which we didn't know how to make Pacman move. However, we were able to add all of the ghosts onto the grid and make the outer border for the maze.
  
Jan 9: Created a Pacman class which allowed us to set the Pacman's coordinates to certain points on the grid. It also allowed us to keep track of the Pacman on the grid.

Jan 10: Figured out how to make the KeyListener respond to arrow keys but didn't know how to make the Pacman move. We also experimented with how to make the ghosts move continuously like an animation.

Jan 11: We were able to add an image of Pacman to one space above/below/left/right of the previous position of the pacman. However, one major problem appeared as we were unable to make the original image of pacman that was still in the previous position disappear. The Pacman would also appear to be cropped.

Jan 12: Spent a day working on how to fix the problems stated in Jan 11 - we finally figured out why there was a problem and now we had to fix the errors in our code. We also added the images reflecting the different orientations of Pacman.

Jan 13: We fixed all the issues stated in Jan 11 so that Pacman is no longer cropped and only one image of Pacman appears on the screen! We continued experimenting with how to make the ghosts move continuously. We were able to make the ghost move and recognize a boundary. In addition, we finally started officially making the walls for the maze, only completing the outer border at this point. (This was accomplished differently than how the outer border was made originally.)

Jan 14: We finally finished created the walls of the maze. We were also able to make the image of Pacman that showed up on the screen reflect the direction in which he was moving. Pacman could now recognize the walls as borders, so Pacman could not go through the walls. After finishing up the development of Pacman, we turned to the development of the four ghosts (Inky, Pinky, Blinky, and Clyde). We created a enemy class (similar to the Pacman class) which we used to track the locations of the ghosts and also set their coordinates to a certain point on the grid. At the end of the day, we were able to make all the ghosts move randomly. Unfortunately, we were unable to figure out how to make the ghosts chase Pacman as it proved a bit too challenging.  
          
Jan 15: Added Pac-Dots onto the maze, which are the tiny dots that Pacman eats. In addition, we also adjusted the speed of the ghosts as they were going a bit too slow. We also experimented with using a timer to move Pacman since he was going way too fast when you held down the arrow keys. However, the timer made the Pacman lag, so we decided to go back to the KeyListener without the timer. We also fixed a bug where the images would split in half if they were on the same "cell" of the grid. Another feature we achieved was making the ghosts recognize the walls as borders. However, this feature was bugged, as the ghosts would recognize the border sometimes, but not all the time, and as a result, it looked the ghosts were jumping over the walls sometimes. We also changed the dimensions of the maze because the original maze was too big. 

Jan 17: We wanted to implement a life system with Pacman, so we added a "life" instance variable in the Pacman class.

Jan 18: Running into Ghosts will make Pacman lose one life, and when Pacman has zero lives, you lose! In the losing screen, you have an option to restart the game or exit the game. If Pacman still has lives, he and the ghosts respawn to their original positions. We also encountered an error in which Pacman was being cropped by the Pac-Dots but managed to fix it in the same day.

Jan 19: We made an official game file and combined the code we were working on. We also coded the "winning" portion of the game in which the user would win when all the Pac-Dots and Power Pellets were eaten. After winning the game, the user would then be given an option to continue or quit the game. However, the winning method was bugged as the user would not be able to win at times.

Jan 20: We fixed the winning method, and it is guaranteed that upon eating all the Pacdots and Power Pellets, you win the game! We also implemented the Power Pellet portion of the game. The goal of the Power Pellet is to give Pacman the ability to eat the ghosts during the seven second span after Pacman eats the pellet. When ghosts are eaten, they respawn in their original positions. We also changed the image of the ghosts when Pacman eats the Power Pellet so that they all are displayed as "blue ghosts." In addition, we fixed the bug where the ghosts would go through the walls, so now all of the ghosts recognize the walls at all times! We also implemented a score system, so each time Pacman eats a dot, the score (displayed at the bottom of the screen) increases by 1, and when Pacman eats a Power Pellet, the score increases by 20.






