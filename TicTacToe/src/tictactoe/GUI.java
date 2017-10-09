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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Araf Al-Jami
 */
public class GUI extends JFrame {
    
    private Game game;
    private int player;
    
    GUI() {
        InitGUI();
        game = new Game();
        player = 1;
    }
    
    private void InitGUI() {
        JButton[] boardButtons = new JButton[9];
        
        JButton menuButtonNewGame = new JButton( "New Game" );
        JButton menuButtonAbout = new JButton( "About" );
        JButton menuButtonQuit = new JButton( "Quit" );
        
        JButton aboutBack = new JButton( "Back" );
        
        JButton gameTypeSingle = new JButton( "Vs AI" );
        JButton gameTypeTwo = new JButton( "Vs Other" );
        JButton gameTypeBack = new JButton( "Back" );
        
        JLabel About = new JLabel( "Developed by: Araf Al-Jami" );
                
        CardLayout cardLayout = new CardLayout();
        
        JPanel cards = new JPanel( cardLayout );
        JPanel menu = new JPanel();
        JPanel about = new JPanel();
        JPanel board = new JPanel( new GridLayout( 3, 3 ) );
        JPanel gameType = new JPanel();
        
        menu.setLayout( new BoxLayout( menu, BoxLayout.Y_AXIS ) );
        about.setLayout( new BoxLayout( about, BoxLayout.Y_AXIS ) );
        gameType.setLayout( new BoxLayout( gameType, BoxLayout.Y_AXIS ) );
        
        menuButtonNewGame.setAlignmentX( Component.CENTER_ALIGNMENT );
        menuButtonAbout.setAlignmentX( Component.CENTER_ALIGNMENT );
        menuButtonQuit.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        aboutBack.setAlignmentX( Component.CENTER_ALIGNMENT );
        About.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        gameTypeSingle.setAlignmentX( Component.CENTER_ALIGNMENT );
        gameTypeTwo.setAlignmentX( Component.CENTER_ALIGNMENT );
        gameTypeBack.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        menuButtonNewGame.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                cardLayout.show( cards, "gameType" );
            } 
        });
        
        menuButtonAbout.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                cardLayout.show( cards, "about" );
            } 
        });
        
        menuButtonQuit.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                System.exit( 0 );
            } 
        });
        
        aboutBack.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                cardLayout.show( cards, "menu" );
            } 
        });
        
        gameTypeSingle.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                game.Init();
                game.SetGameType( 1 );
                cardLayout.show( cards, "board" );
            } 
        });
        
        gameTypeTwo.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                game.Init();
                game.SetGameType( 2 );
                cardLayout.show( cards, "board" );
            } 
        });
        
        gameTypeBack.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                cardLayout.show( cards, "menu" );
            } 
        });
        
        for( int i=0; i<9; i++ ) {
            boardButtons[i] = new JButton( "" );
        }
        
        boardButtons[0].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[0].setEnabled( false );
                boardButtons[0].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 0, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[1].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[1].setEnabled( false );
                boardButtons[1].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 1, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[2].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[2].setEnabled( false );
                boardButtons[2].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 2, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[3].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[3].setEnabled( false );
                boardButtons[3].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 3, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[4].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[4].setEnabled( false );
                boardButtons[4].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 4, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[5].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[5].setEnabled( false );
                boardButtons[5].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 5, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[6].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[6].setEnabled( false );
                boardButtons[6].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 6, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[7].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[7].setEnabled( false );
                boardButtons[7].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 7, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        boardButtons[8].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                boardButtons[8].setEnabled( false );
                boardButtons[8].setText( player == 1 ? "X" : "O" );
                game.SetBoardState( 8, player );
                player = player == 1 ? 2 : 1;
                game.Next();
            } 
        });
        
        menu.add( Box.createVerticalGlue() );
        menu.add( menuButtonNewGame );
        menu.add( Box.createVerticalGlue() );
        menu.add( menuButtonAbout );
        menu.add( Box.createVerticalGlue() );
        menu.add( menuButtonQuit );
        menu.add( Box.createVerticalGlue() );
        
        about.add( Box.createVerticalGlue() );
        about.add( About );
        about.add( Box.createVerticalGlue() );
        about.add( aboutBack );
        about.add( Box.createVerticalGlue() );
        
        gameType.add( Box.createVerticalGlue() );
        gameType.add( gameTypeSingle );
        gameType.add( Box.createVerticalGlue() );
        gameType.add( gameTypeTwo );
        gameType.add( Box.createVerticalGlue() );
        gameType.add( gameTypeBack );
        gameType.add( Box.createVerticalGlue() );
        
        for( int i=0; i<9; i++ ) {
            board.add( boardButtons[i] );
        }
        
        cardLayout.addLayoutComponent( menu, "menu" );
        cardLayout.addLayoutComponent( board, "board" );
        cardLayout.addLayoutComponent( about, "about" );
        cardLayout.addLayoutComponent( gameType, "gameType" );
        
        cards.add( menu );
        cards.add( about );
        cards.add( board );
        cards.add( gameType );
        
        add( cards );
        
        setTitle( "Tic Tac Toe");
        setSize( 300, 300 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
}
