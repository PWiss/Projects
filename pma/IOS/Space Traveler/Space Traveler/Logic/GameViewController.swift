//
//  GameViewController.swift
//  Space Traveler
//
//  Created by juli on 19.12.18.
//  Copyright © 2018 juli. All rights reserved.
//
import Foundation
import UIKit
import SpriteKit
import GameplayKit

class GameViewController: UIViewController {

  
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if let view = self.view as! SKView? {
            // Load the SKScene from 'GameScene.sks'
            let scene = SKScene(fileNamed: "HighscoreScene")
            
            // Set the scale mode to scale to fit the window
            scene!.scaleMode = .aspectFill
            
            // Present the scene
            view.presentScene(scene)
            view.ignoresSiblingOrder = true
            view.showsFPS = false
            view.showsNodeCount = false
        }
    }
    override var shouldAutorotate: Bool {
        return true
    }

    override var supportedInterfaceOrientations: UIInterfaceOrientationMask {
        if UIDevice.current.userInterfaceIdiom == .phone {
            return .allButUpsideDown
        } else {
            return .all
        }
    }

    override var prefersStatusBarHidden: Bool {
        return true
    }

    
    

}
