import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject var viewModel: ContentViewModel = .init()
    
    var body: some View {
        VStack(alignment: .center) {
            Text("Press for color")
            Button(action: {
                // Действие по кнопке
                self.viewModel.presenter?.randomizeColor()
            }) {
                Text("Change color")
            }
        }.padding(10)
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
