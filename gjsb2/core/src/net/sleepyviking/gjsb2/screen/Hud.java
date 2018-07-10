package net.sleepyviking.gjsb2.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.sleepyviking.gjsb2.GJSBGame;

import javax.swing.*;

public class Hud {

    public Stage stage;
    private Viewport viewport;

    private FileHandle skinHandle = Gdx.files.internal("uiskin.json");

    float centerPad;
    float itemWidth;
    float itemHeight;

    public Hud(SpriteBatch spritebatch){

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, spritebatch);
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(skinHandle);

        TextButton startButton = new TextButton("Start", skin);
        centerPad = Gdx.graphics.getHeight() * 1/27;
        itemWidth = Gdx.graphics.getWidth() * 1/2;
        itemHeight = Gdx.graphics.getHeight() * 1/8;

        Table table = new Table(skin);
        table.top();
        table.setFillParent(true);

        table.add("find file").center().pad(centerPad);
        table.row().height(itemHeight);
        table.add(startButton).width(itemWidth).pad(5f);
        table.row().height(itemHeight);
        stage.addActor(table);

        //Listeners

        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JFileChooser chooser = new JFileChooser();
                        JFrame f = new JFrame();
                        f.setVisible(true);
                        f.toFront();
                        f.setVisible(false);
                        int res = chooser.showSaveDialog(f);
                        f.dispose();
                        if (res == JFileChooser.APPROVE_OPTION) {
                            //Do some stuff
                        }
                    }
                }).start();
            }
        });
    }
}
