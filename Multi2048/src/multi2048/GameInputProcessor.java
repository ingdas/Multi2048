/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi2048;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 *
 * @author ingmar
 */
public class GameInputProcessor implements InputProcessor {

    private Multi2048 multi;
    public GameInputProcessor(Multi2048 multi){
        this.multi = multi;
    }
    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.DOWN) {
            multi.b.move(Direction.DOWN, 0);   
            switchInputProcessor();
        } else if (keycode == Keys.UP) {
            multi.b.move(Direction.UP, 0);
            switchInputProcessor();
        } else if (keycode == Keys.RIGHT) {
            multi.b.move(Direction.RIGHT, 0);
            switchInputProcessor();
        } else if (keycode == Keys.LEFT) {
            multi.b.move(Direction.LEFT, 0);
            switchInputProcessor();
        }

        return false;
    }

    private void switchInputProcessor() {
        if(multi.b.isFinished(0)){
            Gdx.input.setInputProcessor(new MenuInputProcessor(multi));
            multi.menu = true;
        }else{
            multi.b.addBlock(0);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
