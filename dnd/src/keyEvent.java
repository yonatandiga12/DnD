import Interfaces.InputProvider;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyEvent implements InputProvider, java.awt.event.KeyListener {
    @Override
    public void getAction() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("you typed: "+e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("you Pressed: "+e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: "+e.getKeyChar());
    }
}
