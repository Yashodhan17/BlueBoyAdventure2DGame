package entity;

import java.awt.Rectangle;

import main.GamePanel;
import object.OBJ_Axe;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

public class NPC_Merchant extends Entity{

	public NPC_Merchant(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y =16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;

		
		getImage();
		setDialouge();
		setItems();
	}
	
    public void getImage() {
		
		up1 = setup("/npc/merchant_down_1",gp.tileSize, gp.tileSize);
		up2 = setup("/npc/merchant_down_2",gp.tileSize, gp.tileSize);
		down1 = setup("/npc/merchant_down_1",gp.tileSize, gp.tileSize);
		down2 = setup("/npc/merchant_down_2",gp.tileSize, gp.tileSize);
		left1 = setup("/npc/merchant_down_1",gp.tileSize, gp.tileSize);
		left2 = setup("/npc/merchant_down_2",gp.tileSize, gp.tileSize);
		right1 = setup("/npc/merchant_down_1",gp.tileSize, gp.tileSize);
		right2 = setup("/npc/merchant_down_2",gp.tileSize, gp.tileSize);
	}
    public void setDialouge() {
    	
    	dialouges[0][0] = "He he, so you found me.\nI have some good stuff.\nDo you want to trade?";
    	dialouges[1][0] = "Come again, hehe!";
    	dialouges[2][0] = "You need more Coins to buy that!";
    	dialouges[3][0] = "You cannot carry any more!";
    	dialouges[4][0] = "You cannot sell an equipped Item!"; 
    }
    public void setItems() {
    	
    	inventory.add(new OBJ_Potion_Red(gp));
    	inventory.add(new OBJ_Key(gp));
    	inventory.add(new OBJ_Sword_Normal(gp));
    	inventory.add(new OBJ_Axe(gp));
    	inventory.add(new OBJ_Shield_Wood(gp));
    	inventory.add(new OBJ_Shield_Blue(gp));
    }
    public void speak() {
    	facePlayer();
    	gp.gameState = gp.tradeState;
    	gp.ui.npc = this;
    }
}
