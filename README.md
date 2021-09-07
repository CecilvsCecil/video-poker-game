Video Poker game

================================================================================
Card Class
================================================================================
There are 2 instance variables which are integers representing the suit 
(1 - clubs, 2 - diamonds, 3 - hearts, 4 - spades) and the rank (1 - ace, 2-10, 
11 - jack, 12 - queen, 13 - king). I overloaded the constructor so that Card 
objects can be created either with integer parameters for the rank and suit or 
with the string notation "s1" or "c2". The compareTo() method orders cards by 
rank first, and then uses an alphabetical ordering of suits to break ties.
Accessor methods for rank and suit are provided as well as a toString() method
that makes use of two private methods that obtain the rank name and suit name
from their integer values.

================================================================================
Deck Class
================================================================================
2 instance vaiables for the 52-card array and an integer representing the top 
index. The constructor instantiates the array with a nested for loop structure
and initializes the top variable to index 0. The shuffle method is implemented
by generating two random indexes within the array and swapping the cards at 
those indexes about 1000 times using a for loop. top is also reset to 0 after 
each shuffle. The deal method returns the top card and increments the top 
variable as long as there are still unused cards in the deck. If not, a shuffle 
is performed.

================================================================================
Player Class
================================================================================
3 instance variables: an arraylist of cards representing the hand, a double for 
the player's bet and  another for the bankroll. The constructor initializes 
bankroll to 100 since the player starts out with 100 tokens in this game. 
Methods addCard() and removeCard() are provided for adding and removing cards as
well as an accessor for the bankroll. The bets() method sets bet to the number 
of tokens the player wishes to bet and deducts them from bankroll. winnings() 
pays out tokens won by adding the product of bet and odds to the bankroll. 
printHand() displays the hand to the player, getHand() simply returns the hand 
and resetHand() clears the hand for the next round.

================================================================================
Game Class
================================================================================
3 instance variables for the player, a deck and a scanner. The constructor is 
overloaded to operate a test game in the first instance and a n interactive game
in the second. The test game constructor makes use of the overloaded Card
constructor to create cards using string notation such as "s1" as input before 
adding them to the player's hand. 
play() 
For the interactive game, the player is first prompted to place his bet. This is 
achieved by calling the placeBet() helper method which simply takes user input 
for the number of tokens to bet and returns it as an integer. The deck ithen 
shuffled, and 5 cards are dealt to the player's hand. The player is then asked 5
questions, one for each card -- whether it should be replaced or not. The cards 
are then replaced. This is handled by the askReplace() helper method which asks
the questions and replaces the stipulated cards. This is done by calling 
removeCard() and addCard() on player with the help of a replaceCount variable 
that increments with each replacement to ensure that right cards are removed 
even when the ArrayList shifts the indexes and also ensures that the right 
number of cards are dealt as replacements in the for loop. The hand is then 
passed into checkHand() to be evaluated. This is done by first sorting the hand
and calling helper methods for each check in descending order to return the 
string that corresponds to the strongest possible hand. This string is then 
passed into the helper method determinePayout() which returns the payout 
associated with the hand obtained. This is then passed into the winnings() 
method of player to adjust the bankroll accordingly.
Multiple round functionality was added with a while loop.

The test game just evaluates the provided testhand and returns the winnings 
based on the corresponding payout of the hand and the bet that the user is 
prompted for.
Individual checks
check1Pair()- Uses for loop structure to determine number of pairs and returns
true if that number is 1.
check2Pair()- Uses for loop structure to determine number of pairs and returns
true if that number is 2.
check3OfAKind()- For all the possible ways a three of a kind can occur, the 
middle card is always one of the three. So this method sets that middle card as
the yardStick and checks for at least three matches when the for loop is run to
conclude that the hand is at least a three of a kind.
checkStraight()- first checks the special case of the straight with the ace,
king, queen, jack, 10. Then uses a for loop to check if adjacent numbers in the
sorted hand are increasing in rank by 1.
checkFlush()- uses for loop structure to check that suits of consecutive cards 
are the same.
checkFullHouse()- Implements the yardStick methodology of the 3OfAKind check 
and ensures that the pair being tested for is not confused with the three of a
kind cards using an if statement.
check4OfAKind()- Implements the yardStick methodology of the 3OfAKind check and
returns true if at least 4 matches are made.
checkStraightFlush()- calls straight and flush checks.
checkRoyalFlush()- uses if-else statements to test for ace, king, queen, jack 
and 10 of the same suit.

================================================================================
Instructions
================================================================================
Enter an integer 1-5 for number of tokens to be bet. Please follow printed out
instructions in the terminal to the letter. It is possible for players to go 
into debt in this game and the game ends when the players enters no to the 
question Play again?
Enjoy!