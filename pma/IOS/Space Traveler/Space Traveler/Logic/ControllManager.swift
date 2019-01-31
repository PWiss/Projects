//
//  ControllManager.swift
//  Space Traveler
//
//  Created by hdm on 10.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit
import CoreMotion
import UIKit


class ControllManager: SKSpriteNode{
    
    var motionManager = CMMotionManager()
    
    func accel() {
        if motionManager.isAccelerometerAvailable == true {

            motionManager.startAccelerometerUpdates(to: OperationQueue.current!, withHandler:{
                data, error in

                let currentX = CGFloat(PlayerX)
                playerX = CGFloat(data!.acceleration.x)
               
                if data!.acceleration.x < 0 {
                    destX = currentX + CGFloat(data!.acceleration.x * 100)
                }

                else if data!.acceleration.x > 0 {
                    destX = currentX + CGFloat(data!.acceleration.x * 100)
                }

            })
        }

    }
    
    
    
        
}

