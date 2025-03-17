package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	GamePanel gp;
	public static final String objName = "Key";
	
	public OBJ_Key(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 =setup("/objects/key",gp.tileSize, gp.tileSize);
		collision = true;
		description = "[" + name + "]\nIt opens a Door.";
		price = 100;
		stackable = true;
		setDialogue();
	}
	public void setDialogue() {
		
		dialouges[0][0] = "You use the " + name + " and open the door";
		dialouges[1][0] =  "Do you see a lock here?";
	}
	public boolean use(Entity entity) {
		
		
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if(objIndex !=999) {
			startDialogue(this,0);
			gp.playSE(3);
			gp.obj[gp.currentMap][objIndex] = null;
			return true;
		}
		else {
			startDialogue(this,1);
			return false;
		}
	}
}
