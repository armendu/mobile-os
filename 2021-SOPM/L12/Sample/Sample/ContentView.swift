//
//  ContentView.swift
//  Sample
//
//  Created by Armend on 1.7.21.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView {
            List {
                Text("Hello World")
                Text("Hello World")
                Text("Hello World")
            }.navigationTitle("SAMPLE SWIFTUI")
            .listStyle(GroupedListStyle())
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
