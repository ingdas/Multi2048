/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multi2048;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 *
 * @author ingmar
 */
public class MenuInputProcessor implements InputProcessor
{
    private Multi2048 multi;
    public MenuInputProcessor(Multi2048 multi){
        this.multi = multi;
    }
    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.ENTER){
            multi.create();
            Gdx.input.setInputProcessor(new GameInputProcessor(multi));
        }else if(keycode == Keys.ESCAPE){
            Gdx.app.exit();
        }
        return false;
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
