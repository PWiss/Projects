//
//  StartScene.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit

class StartScene: SKScene{
    var play = SKSpriteNode()
    var option = SKSpriteNode()
    
    override func didMove(to view: SKView) {
        
        play = self.childNode(withName: "play") as! SKSpriteNode
        option = self.childNode(withName: "option") as! SKSpriteNode
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        for touch: AnyObject in touches{
            
            let pointTouched = touch.location(in: self)
            if play.contains(pointTouched) {
                
                let sceneMoveTo = GameScene(size: self.size)
                sceneMoveTo.scaleMode = self.scaleMode
                let sceneTransition = SKTransition.fade(withDuration: 0.5)
                self.view!.presentScene(sceneMoveTo, transition: sceneTransition)
            }
            if option.contains(pointTouched) {
                
                let sceneMoveTo = GameoverScene(size: self.size)
                sceneMoveTo.scaleMode = self.scaleMode
                let sceneTransition = SKTransition.fade(withDuration: 0.5)
                self.view!.presentScene(sceneMoveTo, transition: sceneTransition)
            }
        }
        
    }
    
    
    
    
}
