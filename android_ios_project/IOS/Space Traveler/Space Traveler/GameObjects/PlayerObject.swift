//
//  PlayerObject.swift
//  Space Traveler
//
//  Created by hdm on 09.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import GameplayKit


class PlayerObject:Objects {
    
    override func spawn() {
        self.physicsBody = SKPhysicsBody(rectangleOf: self.size)
        self.physicsBody!.affectedByGravity = false
        
        
        self.physicsBody!.categoryBitMask = PhysicsCategories.Player
        self.physicsBody!.collisionBitMask = PhysicsCategories.None
        self.physicsBody!.contactTestBitMask = PhysicsCategories.Enemy
        
        
        self.position = CGPoint(x: CGFloat(screenW)/2, y: CGFloat(screenH)*0.2)
        self.zPosition = 2
    }
    var pos: CGPoint {
        get {
            
            return self.position
        }
        set(newValue) {
            //code to execute
        }
    }
    
    
    
}
