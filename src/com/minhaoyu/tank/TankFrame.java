package com.minhaoyu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {

    private Tank myTank;
    private Tank enemy;

    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());// observer设计模式预习一下

        myTank = new Tank(100, 100, Dir.R);
        enemy = new Tank(150, 150, Dir.D);


    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        enemy.paint(g);
    }


    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);




        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);


        }
    }
}
