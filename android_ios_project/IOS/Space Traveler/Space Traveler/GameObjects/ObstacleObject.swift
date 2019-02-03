//
//  ObstacleObject.swift
//  Space Traveler
//
//  Created by hdm on 12.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import GameplayKit

class ObstacleObject: Objects{
    
    override func spawn() {

        let b:String = n
        
        let randomXStart = Float.random(in: 0 ... screenW)
        let randomXEnd = Float.random(in: 0 ... screenW)
        
        let startPoint = CGPoint(x: CGFloat(randomXStart), y: CGFloat(screenH) * 1.2)
        let endPoint = CGPoint(x: CGFloat(randomXEnd), y: -CGFloat(screenH) * 0.2)
        
        let obstacle = SKSpriteNode(imageNamed: "\(b)")
        obstacle.setScale(1)
        obstacle.position = startPoint
        obstacle.zPosition = 2
        obstacle.physicsBody = SKPhysicsBody(rectangleOf: obstacle.size)
        obstacle.physicsBody!.affectedByGravity = false
        obstacle.physicsBody!.categoryBitMask = PhysicsCategories.Enemy
        obstacle.physicsBody!.collisionBitMask = PhysicsCategories.None
        obstacle.physicsBody!.contactTestBitMask = PhysicsCategories.Player | PhysicsCategories.Bullet
        obstacle.physicsBody!.node?.name = "\(b)"
        
        self.addChild(obstacle)
        
        let moveEnemy = SKAction.move(to: endPoint, duration: speed())
        let deleteEnemy = SKAction.removeFromParent()
        let enemySeqence = SKAction.sequence([moveEnemy, deleteEnemy])
        obstacle.run(enemySeqence)


    }
    func speed() -> Double{
        return 5
    }
    
    
    
    
}
