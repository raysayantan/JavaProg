/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.

 

Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 

Note:

1 <= N <= 1000
*/
class Solution {
    public boolean divisorGame(int N) {
        int counter = 0;
        while(true){
            int div = -1;
            for(int i = 1; i <= N/2; i++){
                if(N%i == 0){
                    div = i;
                    break;
                }
            }
            
            if(div != -1 && N%div == 0){
                N -= div;
                counter++;
            } else {
                break;
            }
        }
        
        if(counter % 2 == 0) return false;
        return true;
    }
}
