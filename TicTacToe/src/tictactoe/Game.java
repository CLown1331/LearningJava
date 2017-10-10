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

import java.util.concurrent.ThreadLocalRandom;
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
        if( moveCount == 9 ) {
            return 3;
        }
        return 0;
    }
    
    public int Next() {
            if( gameType == 1 ) {
                int result = Determine();
            if( result == 1 ) {
                JOptionPane.showMessageDialog( null, "Player One Wins!" );
                ProccesGameOver();
            }
            else if( result == 2 ) {
                JOptionPane.showMessageDialog( null, "Player Two Wins!");
                ProccesGameOver();
            }
            else if( result == 3 ) {
                JOptionPane.showMessageDialog( null, "Tie!");
                ProccesGameOver();
            }
            int returnMove = ComputerMove( 2, 2 );
            if( returnMove == -1 ) {
                return -1;
            }
            board[returnMove] = 2;
            return returnMove - 1;
        }
        int result = Determine();
        if( result == 1 ) {
            JOptionPane.showMessageDialog( null, "Player One Wins!");
            ProccesGameOver();
        }
        else if( result == 2 ) {
            JOptionPane.showMessageDialog( null, "Player Two Wins!");
            ProccesGameOver();
        }
        else if( result == 3 ) {
            JOptionPane.showMessageDialog( null, "Tie!");
            ProccesGameOver();
        }
        return -1;
    }
    
    private void ProccesGameOver() {
        for( int i=0; i<10; i++ ) {
            if( board[i] == 0 ) {
                board[i] = 3;
            }
        }
    }
    
    public boolean SetBoardState( int index, int player ) {
        if( board[ index + 1 ] != 0 ) {
            return false;
        }
        moveCount++;
        board[ index + 1 ] = player;
        return true;
    }
    
    public void SetGameType( int gameType ) {
        this.gameType = gameType;
    }
    
    public int GetGameType() {
        return gameType;
    }
    
    private int ComputerMove( int player , int diffLevel ) {
	int move = -1;
	int cmp = player == 1 ? 2 : 1;
	if( diffLevel == 2 ) {
		int best = -11;
		int temp;
		for( int i=1; i<=9; i++ ) {
                    if( board[i] == 0 ) {
                        board[i] = cmp;
                        moveCount++;
                        temp = -minimax( player );
                        board[i] = 0;
                        moveCount--;
                        if( temp > best ) {
                            best = temp;
                            move = i;
                        }
                    }
		}
	}
	else{
            int pos;
            while( true ) {
                pos = ThreadLocalRandom.current().nextInt() % 9 + 1;
                if( board[pos] != player ) {
                    move = pos;
                    break;
                }
            }
	}
	return move;
    }
    
    private int score( int player ) {
	int enemy = player == 1 ? 2 : 1;
	for( int i=0; i<8; i++ ) {
            if( board[ win_combos[i][0] ] == board[ win_combos[i][1] ]
                                    &&
            board[ win_combos[i][1] ] == board[ win_combos[i][2] ] ) {
                if( board[ win_combos[i][2] ] == player ) {
                        return 10;
                } else if( board[ win_combos[i][2] ] == enemy ) {
                        return -10;
                }
            }
	}
	return 0;
    }
    
    private int minimax( int player ) {
	if( moveCount < 9 ) {
            return score( player );
	}
	int enemy = player == 1 ? 2 : 1;
	int move = -1;
	int best = -11;
	int temp;
	for( int i=1; i<=9; i++ ) {
            if( board[i] == 0 ) {
                board[i] = player;
                moveCount++;
                temp = -minimax( enemy );
                board[i] = 0;
                moveCount--;
                if( temp > best ) {
                    best = temp;
                    move = i;
                }
            }
	}
	if( move == -1 ) {
            return 0;
	}
	return best;
    }
}
