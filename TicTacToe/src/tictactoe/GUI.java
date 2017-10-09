/*
 * The MIT License
 *
 * Copyright 2017 Araf A1-Jami.
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

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Araf Al-Jami
 */
public class GUI extends JFrame {
    GUI() {
        InitGUI();
    }
    
    private void InitGUI() {
        JButton[] boardButtons = new JButton[9];
        JButton menuButtonNewGame = new JButton( "New Game" );
        JButton menuButtonAbout = new JButton( "About" );
        JButton menuButtonQuit = new JButton( "Quit" );
        
        JPanel cards = new JPanel( new CardLayout() );
        JPanel menu = new JPanel();
        JPanel board = new JPanel( new GridLayout( 3, 3 ) );
        
        menu.setLayout( new BoxLayout( menu, BoxLayout.Y_AXIS ) );
        
        menuButtonNewGame.setAlignmentX( Component.CENTER_ALIGNMENT );
        menuButtonAbout.setAlignmentX( Component.CENTER_ALIGNMENT );
        menuButtonQuit.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        menu.add( menuButtonNewGame );
        menu.add( menuButtonAbout );
        menu.add( menuButtonQuit );
        
        for( int i=0; i<9; i++ ) {
            boardButtons[i] = new JButton( "" );
            board.add( boardButtons[i] );
        }
        
        cards.add( menu );
        cards.add( board );
        
        add( cards );
        
        setTitle( "Tic Tac Toe");
        setSize( 300, 300 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
}
