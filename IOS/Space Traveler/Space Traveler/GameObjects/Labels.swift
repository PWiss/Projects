//
//  Labels.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit


class Labels: SKLabelNode {
    
    let scoreLabel = SKLabelNode(fontNamed: "Arial")
    let lifeLabel = SKLabelNode (fontNamed: "Arial")
    let gameoverLabel = SKLabelNode(fontNamed: "Arial")
    
    func updateScore(score: Int){
        scoreLabel.text = "SCORE \(score)"
    }
    
    func score(){
        
        scoreLabel.position = CGPoint(x: CGFloat(screenW*0.70), y: CGFloat(screenH*0.95))
        scoreLabel.fontColor = SKColor.white
        
        scoreLabel.fontSize = 50
        self.addChild(scoreLabel)
    }
    func updateLife(life: Int){
        lifeLabel.text = "LIFE \(life)"
    }
    
    func life(){
        
        lifeLabel.position = CGPoint(x: CGFloat(screenW*0.30), y: CGFloat(screenH*0.95))
        lifeLabel.fontColor = SKColor.white
        
        lifeLabel.fontSize = 50
        self.addChild(lifeLabel)
        
    }
    func gameOver(){
        
        gameoverLabel.position = CGPoint(x: CGFloat(screenW*0.5), y: CGFloat(screenH*0.5))
        gameoverLabel.fontColor = SKColor.white
        
        gameoverLabel.fontSize = 2000
        gameoverLabel.text = "GAME OVER"
        self.addChild(gameoverLabel)
    }
    
    
    
}
