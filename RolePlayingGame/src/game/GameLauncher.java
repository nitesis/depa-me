package game;

public class GameLauncher {
	public static void main(final String[] args) {
		new GameLauncher().launchGame();
	}
	private void launchGame() {
		game.start();		
	}
	public GameLauncher(){
		game = new Game();
	}
	private Game game;
}
