//
//  Enemy.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//


import Foundation
import SpriteKit
import GameplayKit

class Enemy: ObstacleObject{
    override func speed() -> Double{
        return 5
    }
    
    override func points() {
        score += 2
    }
    
    
    
}
