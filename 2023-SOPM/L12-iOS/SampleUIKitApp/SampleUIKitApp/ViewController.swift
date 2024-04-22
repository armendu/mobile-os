//
//  ViewController.swift
//  SampleUIKitApp
//
//  Created by Armend on 2.7.21.
//

import UIKit

class ViewController: UITableViewController {

    let someData : [String] = [
        "Hello 1",
        "Hello 2",
        "Hello 3"
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return someData.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "normalCell", for: indexPath)
        
        cell.textLabel?.text = someData[indexPath.row]
        
        return cell
    }
}

