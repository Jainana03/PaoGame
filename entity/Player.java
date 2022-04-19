package entity;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = 9*gp.tileSize;
        worldY = 13*gp.tileSize;
        speed = 4; 
        direction = "right";   
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/image/animation/Pao1-right2.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //if(keyH.upPressed==true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed==true){
                direction = "up";
                worldY -= speed;
            }else if(keyH.downPressed==true){
                direction = "down";
                worldY += speed;
            }else if(keyH.leftPressed==true){
                direction = "left";
                worldX -= speed;
            }else if(keyH.rightPressed==true){
                direction = "right";
                worldX += speed;
            }
            spritecounter++;
            if(spritecounter>15){
                if(spriteNumber == 1){
                    spriteNumber = 2;   
                }else if(spriteNumber == 2){
                    spriteNumber = 1;
                }
                spritecounter = 0;
            }

        //}else{
            //spriteNumber = 1;
            
        //}
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
            if(spriteNumber == 1){
                image = up1;
            }
            if(spriteNumber == 2){
                image = up2;
            }
            break;
            case "down":
            if(spriteNumber == 1){
                image = down1;
            }
            if(spriteNumber == 2){
                image = down2;
            }
            break;
            case "left":
            if(spriteNumber == 1){
                image = left1;
            }
            if(spriteNumber == 2){
                image = left2;
            }
            break;
            case "right":
            if(spriteNumber == 1){
                image = right1;
            }
            if(spriteNumber == 2){
                image = right2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}
