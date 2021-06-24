import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {

    private int x,y;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    public static final int SPEED = 5;



    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,60,60);
        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT:
                dir = Dir.L;
                x -= SPEED;
                bL = true;
                break;

            case KeyEvent.VK_UP:
                dir =Dir.U;
                y -= SPEED;
                bU = true;
                break;

            case KeyEvent.VK_DOWN:
                dir =Dir.D;
                y += SPEED;
                bD = true;
                break;

            case KeyEvent.VK_RIGHT:
                dir =Dir.R;
                x += SPEED;
                bR = true;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + key);
        }
    setMainDir();

    }

    private void setMainDir() {
        if (!bL && !bU && !bR && !bD){
            dir = Dir.STOP;
        }
        if (bL && !bU && !bR && !bD){
            dir = Dir.L;
        }
        if (!bL && bU && !bR && !bD){
            dir = Dir.U;
        }
        if (!bL && !bU && bR && !bD){
            dir = Dir.R;
        }
        if (!bL && !bU && !bR && bD){
            dir = Dir.D;
        }

    }

    private void move() {
        switch(dir){
            case L:
                x -=SPEED;
                break;
            case U:
                y -=SPEED;
                break;
            case R:
                x +=SPEED;
                break;
            case D:
                y +=SPEED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT:
               bL = false;
                x -= SPEED;
                break;

            case KeyEvent.VK_UP:
                bU = false;
                y -= SPEED;
                break;

            case KeyEvent.VK_DOWN:
                bD = false;
                y += SPEED;
                break;

            case KeyEvent.VK_RIGHT:
                bR = false;
                x += SPEED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + key);
        }
        setMainDir();

    }
}
