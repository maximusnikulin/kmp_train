import SwiftUI
import Shared

struct ContentView: View {
    var ns = NewsService()
    
    @ObservedObject var viewModel: ContentViewModel = .init()
    @State private var res: String = ""
    
    var body: some View {
        VStack(alignment: .center) {
            Text("Press for color")
            Button(action: {
                self.viewModel.presenter?.randomizeColor()
            }) {
                Text("Change color")
            }
            Button(action: {
                Task {
                  res = try await ns.makeCall()
                }
            }) {
                Text("Make rpc call")
            }
            Text(res)
        }
        .padding(10)
        .frame(
            minWidth: 0,
            maxWidth: .infinity,
            minHeight: 0,
            maxHeight: .infinity,
            alignment: .center
        )
        // Цвет из VM
        .background(viewModel.color)
        .onAppear {
            viewModel.setup()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
