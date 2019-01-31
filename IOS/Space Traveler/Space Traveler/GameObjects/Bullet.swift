//
//  Bullet.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import GameplayKit


class Bullet:Objects {
    let bulletSound = SKAction.playSoundFileNamed("b.wav", waitForCompletion: false)
    
    
    
    override func spawn() {
        let b:String = n
        
        let bullet = SKSpriteNode(imageNamed: "\(b)")
        bullet.setScale(1)
        bullet.position = playerP
        bullet.zPosition = 2
        bullet.physicsBody = SKPhysicsBody(rectangleOf: bullet.size)
        bullet.physicsBody!.affectedByGravity = false
        bullet.physicsBody!.categoryBitMask = PhysicsCategories.Bullet
        bullet.physicsBody!.collisionBitMask = PhysicsCategories.None
        bullet.physicsBody!.contactTestBitMask = PhysicsCategories.Enemy
        self.addChild(bullet)
        
        
        
        
        let moveBullet = SKAction.moveTo(y: CGFloat(screenH), duration: 1)
        let deleteBullet = SKAction.removeFromParent()
        let bulletSequence = SKAction.sequence([bulletSound, moveBullet, deleteBullet])
        bullet.run(bulletSequence)
    }
    
    
    
}
