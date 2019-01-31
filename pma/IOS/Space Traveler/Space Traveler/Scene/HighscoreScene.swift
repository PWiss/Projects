//
//  HighscoreScene.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit

class HighscoreScene: SKScene{
    
   
    var menu = SKSpriteNode()
    
    override func didMove(to view: SKView) {
        
        
        let currentScore: SKLabelNode = self.childNode(withName: "currentScore" ) as! SKLabelNode
        currentScore.text = "Score: \(score)"
        if score == 0 {
            currentScore.text = ""
        }
        
        

        let scoreTop1: SKLabelNode = self.childNode(withName: "scoreTop1") as! SKLabelNode
        let scoreTop2: SKLabelNode = self.childNode(withName: "scoreTop2") as! SKLabelNode
        let scoreTop3: SKLabelNode = self.childNode(withName: "scoreTop3") as! SKLabelNode
        let top1 = UserDefaults.standard.integer(forKey: "scoreTop1Saved")
        let top2 = UserDefaults.standard.integer(forKey: "scoreTop2Saved")
        let top3 = UserDefaults.standard.integer(forKey: "scoreTop3Saved")
        scoreTop1.text = "Top 1: \(top1)"
        scoreTop2.text = "Top 2: \(top2)"
        scoreTop3.text = "Top 3: \(top3)"

       
        menu = self.childNode(withName: "back") as! SKSpriteNode
        
    }
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        for touch: AnyObject in touches{
            
            let pointTouched = touch.location(in: self)
           
            if menu.contains(pointTouched) {
                
                let sceneMoveTo = GameScene(size: self.size)
                sceneMoveTo.scaleMode = self.scaleMode
                let sceneTransition = SKTransition.fade(withDuration: 0.5)
                self.view!.presentScene(sceneMoveTo, transition: sceneTransition)
            }
        }
        
    }
    
}
