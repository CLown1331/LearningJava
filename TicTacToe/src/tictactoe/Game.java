/*
 * The MIT License
 *
 * Copyright 2017 clown1331.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tictactoe;

import javax.swing.JOptionPane;

/**
 *
 * @author clown1331
 */
public class Game {
    private int[][] win_combos = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, 
                                   { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 }, { 3, 5, 7 } };
    
    private int[] board = new int[10];
    private int moveCount;
    private int gameType;
    
    Game() {
        Init();
    }
    
    public void Init() {
        for( int i=0; i<10; i++ ) {
            board[i] = 0;
        }
        moveCount = 0;
    }
    
    public int Determine() {
        if( moveCount == 9 ) {
            return 3;
        }
        for( int i=0; i<8; i++ ) {
            if( board[ win_combos[i][0] ] == board[ win_combos[i][1] ]
                                    &&
            board[ win_combos[i][1] ] == board[ win_combos[i][2] ]
            && board[ win_combos[i][2] ] != 0 ) {
                    if( board[ win_combos[i][2] ] == 1 ) {
                        return 1;
                    } else {
                        return 2;
                    }
            }
	}
        return 0;
    }
    
    public void Next() {
        if( gameType == 2 ) {
            int result = Determine();
            if( result == 1 ) {
                int input = JOptionPane.showConfirmDialog( null, "Player One Wins!, Play Again?",
                        "Select an Option...", JOptionPane.YES_NO_OPTION );
                ProccesGameOver( input );
            }
            else if( result == 2 ) {
                int input = JOptionPane.showConfirmDialog( null, "Player Two Wins!, Play Again?",
                        "Select an Option...", JOptionPane.YES_NO_OPTION );
                ProccesGameOver( input );
            }
            else if( result == 3 ) {
                int input = JOptionPane.showConfirmDialog( null, "Tie!, Play Again?",
                        "Select an Option...", JOptionPane.YES_NO_OPTION );
                ProccesGameOver( input );
            }
        }
    }
    
    void ProccesGameOver( int input ) {
        if( input == 0 ) {
            Init();
        }
        else {
            for( int i=0; i<10; i++ ) {
                if( board[i] == 0 ) {
                    board[i] = 3;
                }
            }
        }
    }
    
    public void SetBoardState( int index, int player ) {
        if( board[ index + 1 ] != 0 ) {
            return;
        }
        moveCount++;
        board[ index + 1 ] = player;
    }
    
    public void SetGameType( int gameType ) {
        this.gameType = gameType;
    }
    
    public int GetGameType() {
        return gameType;
    }
}
