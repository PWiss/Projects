//
//  GameObjectManager.swift
//  Space Traveler
//
//  Created by hdm on 26.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit

class GameObjectManager: SKSpriteNode {
    
    let player = PlayerObject(type: "player")
    let astro = Asteroid(type: "asteroid")
    let bullet = Bullet(type: "bullet")
    let background = Background(type: "background4")
    let enemy = Enemy(type: "enemy")
    
    func create(){
        self.addChild(background)
        background.createBackground()
        
        self.addChild(astro)
        self.addChild(enemy)
        
        player.spawn()
        self.addChild(player)
        self.addChild(bullet)
        
        startNewLevel()
    
    }
    
    func shoot(){
        bullet.spawn()
        
    }
    func spawn(){
        
    }
    func startNewLevel(){
        
        let spawn = SKAction.run(spawning)
        let waitToSpawn = SKAction.wait(forDuration: 4)
        let spawnSequence = SKAction.sequence([spawn, waitToSpawn])
        let spawnForever = SKAction.repeatForever(spawnSequence)
        self.run(spawnForever)
    }
    func spawning(){
        astro.spawn()
        enemy.spawn()
        
        
    }
    
    
}
