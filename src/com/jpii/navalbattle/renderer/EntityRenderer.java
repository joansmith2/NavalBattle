package com.jpii.navalbattle.renderer;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import com.jpii.navalbattle.data.Constants;
import com.jpii.navalbattle.game.Game;
import com.jpii.navalbattle.game.Location;
import com.jpii.navalbattle.game.entity.Entity;
import com.jpii.navalbattle.game.entity.Whale;

/**
 * Renders entities to the screen. Has some very useful methods.
 * @author MKirkby
 *
 */
public class EntityRenderer {
    BufferedImage buffer;
    Grid grid;
    /**
     * Creates a new Entity renderer.
     * @param grid The game's current grid.
     */
    public EntityRenderer(Grid grid) {
        this.grid = grid;
        BufferedImage whale = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        grid.setEntity(new Whale(new Location(3, 3), whale, null, "whale1", 100));
        buffer = new BufferedImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }
    /**
     * Gets the buffer of the entity.
     * @return
     */
    public BufferedImage getBuffer() {
        return buffer;
    }
    /**
     * Renders the Entity to the screen.
     * @param game
     */
    public void render(Game game) {
        buffer = new BufferedImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = buffer.getGraphics();
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                // Do entity rendering here.
                Entity ent = grid.getEntity(x, y);
                if (ent != null) {
                    Point p = gridLocationToScreen(ent.getLocation(), game);
                    int px = p.x;
                    int py = p.y;
                    g.drawImage(ent.getImage(), px, py, null);
                }
            }
        }
    }
    /**
     * Converts a grid location to screen coordinates.
     * @param l The location to convert.
     * @param g The game.
     * @return A point on the screen (its possible that it might not be on the screen).
     */
    public Point gridLocationToScreen(Location l, Game g) {
        Point p = gridLocationToPoint(l);
        Point s = pointToScreen(p.x, p.y, g);
        return s;
    }
    /**
     * Converts a point on the screen to a grid location. UNTESTED and MAY NOT WORK AT ALL.
     * @param px The x coordinate.
     * @param py The y coordinate.
     * @return The Location on the grid. Its possible that it may not be a valid location at all.
     */
    public Location pointToGridLocation(int px, int py) {
        int x = ((Constants.WINDOW_WIDTH * 4) / Constants.CHUNK_SIZE) / px * 2;
        int y = ((Constants.WINDOW_HEIGHT * 4) / Constants.CHUNK_SIZE) / py * 2;
        return new Location(x, y);
    }
    /**
     * Converts a grid location into a point (not on screen, so it may not be useful at all).
     * @param l The location to convert.
     * @return The point in the world.
     */
    public Point gridLocationToPoint(Location l) {
        int px = l.getRow();
        int py = l.getCol();
        int x = px * Constants.CHUNK_SIZE;
        int y = py * Constants.CHUNK_SIZE;
        return new Point(x, y);
    }
    /**
     * Converts a point in the world, into a point in the screen.
     * @param px The x point in the world.
     * @param py The y point in the world.
     * @param g The game.
     * @return A point. (May not physically be on the screen, and may be negative.)
     */
    public Point pointToScreen(int px, int py, Game g) {
        Point p = g.getMouseSet();
        Point y = new Point((px / 2) - p.x, (py / 2) - p.y);
        return y;
    }
}