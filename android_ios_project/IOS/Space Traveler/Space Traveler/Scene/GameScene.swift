//
//  GameScene.swift
//  Space Traveler
//
//  Created by juli on 19.12.18.
//  Copyright © 2018 juli. All rights reserved.
//

import SpriteKit
import GameplayKit

class GameScene: SKScene, SKPhysicsContactDelegate {
    let objectControll = GameObjectManager()
    
    let explosion = SKAction.playSoundFileNamed("explo.mp3", waitForCompletion: false)
    let music = SKAction.playSoundFileNamed("song.mp3", waitForCompletion: false)
    var backgroundMusic: SKAudioNode!
    
    let label = Labels()
    

    let controll = ControllManager()
    let game = GameViewController()
    
    func random() -> CGFloat {
        return CGFloat(Float(arc4random()) / 0xFFFFFFFF)
    }
    func random(min: CGFloat, max: CGFloat) -> CGFloat {
        return random() * (max - min) + min
    }
    
    var gameArea: CGRect
    
    override init(size: CGSize) {
        
        let maxAspectRatio: CGFloat = 16.0/9.0
        let playableWidth = size.height / maxAspectRatio
        let margin = (size.width - playableWidth) / 2
        gameArea = CGRect(x: margin, y: 0, width: playableWidth, height: size.height)
        
        super.init(size: size)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError()
    }
    
    override func didMove(to view: SKView) {
        
//        run(music)
        
        score = 0
        life = 3
        
        let sceneWidth: CGFloat = self.size.width
        let sceneHeight: CGFloat = self.size.height
        screenW = Float(floor(sceneWidth))
        screenH = Float(floor(sceneHeight))
        screenS = self.size
        
        self.physicsWorld.contactDelegate = self
        
    
        objectControll.create()
        self.addChild(objectControll)
        

        label.life()
        label.score()
        self.addChild(label)
        controll.accel()
       
 
        
    }
    

    
    
    func didBegin(_ contact: SKPhysicsContact) {
        
        var body1 = SKPhysicsBody()
        var body2 = SKPhysicsBody()
        
        if contact.bodyA.categoryBitMask < contact.bodyB.categoryBitMask{
            body1 = contact.bodyA
            body2 = contact.bodyB
        }
        else{
            body1 = contact.bodyB
            body2 = contact.bodyA
        }
        
        if body1.categoryBitMask == PhysicsCategories.Player && body2.categoryBitMask == PhysicsCategories.Enemy{
            
          
            life -= 1

        if life == 0 {
                body1.node?.removeFromParent()
                checkScore()
                self.run(explosion)
                objectControll.removeFromParent()
            
            
            
            
                let waitToChangeScene = SKAction.wait(forDuration: 1)
                let changeScene = SKAction.run{
                let sceneToMoveTo = SKScene(fileNamed: "HighscoreScene")!
                sceneToMoveTo.scaleMode = self.scaleMode
                let sceneTransition = SKTransition.fade(withDuration: 0.5)
                self.view!.presentScene(sceneToMoveTo, transition: sceneTransition)
                
            }
            let sceneChangeSequence = SKAction.sequence([waitToChangeScene, changeScene])
            self.run(sceneChangeSequence)
            
                
            }
            body2.node?.removeFromParent()
            }
        
        if body1.categoryBitMask == PhysicsCategories.Bullet && body2.categoryBitMask == PhysicsCategories.Enemy{
            //bullet hit
            self.run(explosion)
            
            
            body1.node?.removeFromParent()
        if body2.node?.name == "enemy" {
                objectControll.enemy.points()             }
        if body2.node?.name == "asteroid" {
                objectControll.astro.points()
            }
        
            body2.node?.removeFromParent()
            
        }
        
    }
    
    override func update(_ currentTime: TimeInterval) {
        
        objectControll.player.position.x += destX
        playerP = objectControll.player.position
    
      
        checkPos()
        
        label.updateScore(score: score)
        label.updateLife(life: life)
        
        
        
    }
    
    
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
       objectControll.shoot()
        
        
    }
    
    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch: AnyObject in touches{
            let pointOfTouch = touch.location(in:self)
            let previousPointOfTouch = touch.previousLocation(in:self)
            
            let amountDragged = pointOfTouch.x - previousPointOfTouch.x
            
            objectControll.player.position.x += amountDragged
            
            
            
        }
    }
    
    
    
    func checkPos(){
        if objectControll.player.position.x > gameArea.maxX - objectControll.player.size.width/2 {
            objectControll.player.position.x = gameArea.maxX - objectControll.player.size.width/2
        }
        if objectControll.player.position.x < gameArea.minX + objectControll.player.size.width/2 {
            objectControll.player.position.x = gameArea.minX + objectControll.player.size.width/2
        }    }
    

    
        
        
       
    }
    
    
   
    
    

