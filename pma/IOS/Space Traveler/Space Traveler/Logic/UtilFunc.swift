//
//  UtilFunc.swift
//  Space Traveler
//
//  Created by hdm on 12.01.19.
//  Copyright © 2019 juli. All rights reserved.
//

import Foundation
import SpriteKit

func checkScore(){
    
    let s1 = UserDefaults.standard.integer(forKey: "scoreTop1Saved")
    let s2 = UserDefaults.standard.integer(forKey: "scoreTop2Saved")
    let s3 = UserDefaults.standard.integer(forKey: "scoreTop3Saved")
    
    if score > s1{
        UserDefaults.standard.set(score, forKey: "scoreTop1Saved")
        UserDefaults.standard.set(s1, forKey: "scoreTop2Saved")
        UserDefaults.standard.set(s2, forKey: "scoreTop3Saved")
    }else if score > s2{
        
        UserDefaults.standard.set(score, forKey: "scoreTop2Saved")
        UserDefaults.standard.set(s2, forKey: "scoreTop3Saved")
    }else if score > s3{
        UserDefaults.standard.set(score, forKey: "scoreTop3Saved")
}
}

