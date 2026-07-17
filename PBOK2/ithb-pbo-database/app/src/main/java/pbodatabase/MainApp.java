package pbodatabase;

import pbodatabase.controllers.AuctionController;
import pbodatabase.views.AuctionView;

public class MainApp {
    public static void main(String[] args) {
        AuctionController controller = new AuctionController();
        
        AuctionView view = new AuctionView(controller);
        
        view.displayMenu();
    }
}