package dev.razil.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Date;

import dev.razil.tilegame.Game;
import dev.razil.tilegame.Handler;
import dev.razil.tilegame.entities.Entity;
import dev.razil.tilegame.gfx.Animation;
import dev.razil.tilegame.gfx.Assets;
import dev.razil.tilegame.inventory.Inventory;

public class Player extends Creature {
	
	protected int playerMove = 1;
	private int attack =0;
	private int at = 0;
	private int atM = 0;
	int i=2;
	private int hit;
	
	//Animation
	private Animation animDown,animUp,animLeft,animRight;
	//Attack Timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private long lastAttackTimerA, attackCooldownA = 350, attackTimerA = attackCooldownA;
	
	//Inventory
	private Inventory inventory;
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Player Collision
		bounds.x =20;
		bounds.y = 36;
		bounds.width =24;
		bounds.height =24;
		
		//Animation
		animDown = new Animation(500, Assets.playerD);
		animUp = new Animation(500, Assets.playerU);
		animLeft = new Animation(500, Assets.playerL);
		animRight = new Animation(500, Assets.playerR);
		
		//Inventory
		inventory = new Inventory(handler);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public void tick() {
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centeredOnEntity(this);
		
		//Attack
		checkAttacks();
		//AttackM
		checkAttacksM();
		//Inventory
		inventory.tick();
	}
	
	public static void delay(int t) {
		long end = (new Date()).getTime() + t;
		while ((new Date()).getTime() < end) {

		}
	}
	
	private void checkAttacksM(){
		attackTimerA += System.currentTimeMillis()- lastAttackTimerA;
		atM=1;
		lastAttackTimerA = System.currentTimeMillis();
		if(attackTimerA > attackCooldownA){
			atM =0;
			return;
			
		}}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis()- lastAttackTimer;
		at=1;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown){
			at =0;
			
			return;
		}
		if(inventory.isActive()){
			return;
		}
		
		
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2- arSize /2;
			ar.y = cb.y - arSize;
			attack = 1;
			hit = 3;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2- arSize /2;
			ar.y = cb.y + ar.height;
			attack = 1;
			hit=4;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize /2;
			attack = 1;
			hit =1;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize /2;
			attack = 1;
			hit = 2;
		}else{
			attack = 0;
			return;
		}
		
		attackTimer =0;
		attackTimerA =0;
		
		//For not Hurting Yourself
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				continue;
			}if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				
				return;
			}
		}
	}
	
	@Override
	public void die(){
		System.out.println("lose");
	}
	
	private void getInput(){
		xMove =0;
		yMove =0;
		if(inventory.isActive()){
			return;
		}
		
		if(handler.getKeyManager().up){
			yMove = -speed;
			playerMove = 1;
			}
			
		if(handler.getKeyManager().down){
			yMove = speed;
			playerMove = 2;
			}
		
		if(handler.getKeyManager().left){
			xMove = -speed;
			playerMove = 3;
			}
		
		if(handler.getKeyManager().right){
			xMove = speed;
			playerMove = 4;
			}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		if(attack ==1 && atM ==1) {
			g.drawImage(getCurentFrameAttack(),(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		
	}
	public void postRender(Graphics g){
		inventory.render(g);
	}
	
	private BufferedImage getCurentFrame(){
		
		if(xMove <0){
			i=0;
			return animLeft.getCurentFrame();
		}else if(xMove >0){
			i=1;
			return animRight.getCurentFrame();
		}else if(yMove <0){
			i=3;
			return animUp.getCurentFrame();
		}else if (yMove >0){
			i=2;
			return animDown.getCurentFrame();
		}else{
			return Assets.playerS[i];
		}
		
	}
	private BufferedImage getCurentFrameAttack(){
		if(hit ==1){
			return Assets.Attack[2];
		}else if(hit ==2){
			return Assets.Attack[3];
		}else if(hit ==3){
			return Assets.Attack[1];
		}else if (hit ==4){
			return Assets.Attack[0];
		}else{
			return null;
		}
		
	}
	public enum Stand{
		DOWN,UP,RIGHT,LEFT
	}

}