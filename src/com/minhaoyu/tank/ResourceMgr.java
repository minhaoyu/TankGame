package com.minhaoyu.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage goodTankU;

    static {
        try {
            goodTankU = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("images/GoodTank1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
