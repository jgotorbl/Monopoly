# Monopoly
Single Player monopoly game using Java

The game is composed by a board of spaces, and a monopoly player that 
rolls the dices and earn a certain amount of credits on each round, depending
on which kind of spaces he falls into.

The board has 40 spaces, and there are different types of spaces (Property, Railroads,
Chance, Community Chest, Supplier, Tax Office, ..). There is a Space class that is abstract 
and contains all the common functionality of the spaces. 

When the game starts, a JSON file called BoardData - which contains information about the index, 
the name, and the credits of each spot is read and the information gets parsed into a board of 
"Spaces". 

Then, the player rolls the dices and moves his token on the board. Depending on which kind of Space 
the player falls into, a certain amount of credits will be awarded. 

The game ends when the player passes the initial "GO" position, and the total number of credits awarded 
is returned.
