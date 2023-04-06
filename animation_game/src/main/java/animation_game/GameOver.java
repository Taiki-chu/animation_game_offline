package animation_game;

import java.awt.Graphics;

public class GameOver {
//	BattleGui battleGui;
	
	private static int count = 0 ;

	public GameOver() {
		count = 0;
	}
	public void draw(Graphics g) {
		count += 5;
		for(int i = 1 ; i <= count ; i++ ) {
			DrawMethod.drawLine( 0, i , BattleGui.w, i , g );
		}
		
		if(count >= BattleGui.h) {
			BattleGui.timer.stop();
			BattleGui.frame.setVisible(false);
			Menu.frame.setVisible(true);
		}
		
	}
}
