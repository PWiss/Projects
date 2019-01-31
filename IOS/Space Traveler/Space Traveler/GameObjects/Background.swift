//
//  Background.swift
//  Space Traveler
//
//  Created by hdm on 25.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import GameplayKit

class Background: Objects {
    
    func createBackground(){

    
    self.size = (screenS)
    self.position = CGPoint(x: CGFloat(screenW)/2, y: CGFloat(screenH)/2)
    self.zPosition = -1
    
    }
}
