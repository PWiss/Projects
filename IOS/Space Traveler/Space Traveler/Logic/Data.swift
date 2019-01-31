//
//  Data.swift
//  Space Traveler
//
//  Created by hdm on 11.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit


    
var life: Int = 0
var score: Int = 0
var screenW: Float = 0
var screenH: Float = 0
var screenS = CGSize(width: 100, height: 100)

var PlayerX: Float = 0
var destX:CGFloat = 0.0
var playerX:CGFloat = 0.0
var playerP = CGPoint(x: 0, y: 0)

struct PhysicsCategories{
    static let None: UInt32 = 0
    static let Player: UInt32 = 0b1 //1
    static let Bullet: UInt32 = 0b10 //2
    static let Enemy: UInt32 = 0b100 //4
    
}

