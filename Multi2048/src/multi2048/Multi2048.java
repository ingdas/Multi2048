package multi2048;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Multi2048 implements ApplicationListener {

    private SpriteBatch batch;
    public Board b;
    public boolean menu;
    private BitmapFont font;

    @Override
    public void create() {
        font =  new BitmapFont();
        font.setColor(Color.WHITE);
        
        menu = false;
        b = new Board();
        b.addBlock(0);

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GameInputProcessor(this));
    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        if(menu){
            Gdx.gl.glClearColor(0, 0, 0.0f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


            batch.begin();
                String s1 = "Press Enter to play";
                String s2 = "Press Esc to quit";
                font.draw(batch, s1, 175, 250);
                font.draw(batch,s2,182,150);

            batch.end();
        }else{
            Gdx.gl.glClearColor(0, 0, 0.0f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


            batch.begin();

            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    font.draw(batch, Integer.toString(b.boards[0][i][j] == 0 ? 0 : 1<<b.boards[0][i][j] ), 50+ 50 * j, 250 - 50 * i);
                }
            }

            batch.end();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
