//
//  Objects.swift
//  Space Traveler
//
//  Created by hdm on 08.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import GameplayKit

class Objects:SKSpriteNode, ProtocolObjects {
    
    
    var n = ""
    
    var gameArea: CGRect
    
       
    
    func points(){
        
       
    }
    func spawn(){
        
    }
    
       
    init(type: String) {
            
        let maxAspectRatio: CGFloat = 16.0/9.0
        let playableWidth = CGFloat(screenH) / maxAspectRatio
        let margin = (CGFloat(screenW) - playableWidth) / 2
        gameArea = CGRect(x: margin, y: 0, width: playableWidth, height: CGFloat(screenH))
        n = type
        let texture = SKTexture(imageNamed: "\(type)")
        
       
        super.init(texture: texture, color: SKColor.clear, size: texture.size())
        
        
       
        
    }
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
}
    
    enum objectType{
        case player
        case enemy
    }
    
    
}
